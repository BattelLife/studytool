package com.studydesign.studytoolbasic.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.DateTimePath;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Map;

public class QueryDslUtil {

    //获取分页排序
    public static OrderSpecifier getOrder(Object qObject, PageQuery pageQuery) {
		OrderSpecifier orderSpecifier = pageQuery.getOrder() == Order.ASC ? Order.ASC : Order.DESC;
        return orderSpecifier;
    }

    //获取分页条件
    public static Predicate getPredicate(Object qObject, JSONObject jsonObject) {
        return getPredicate(qObject, jsonObject, true);
    }

    public static Predicate getPredicate(Object qObject, JSONObject jsonObject, boolean isAnd) {
        Predicate predicate = null;
        if (qObject == null && jsonObject == null) {
            return null;
        }
        try {
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                String key = entry.getKey();
                Predicate newPredicate;
                switch (key) {
                    case "and":
                        newPredicate = getPredicate(qObject, jsonObject.getJSONObject(key), true);
                        break;
                    case "or":
                        newPredicate = getPredicate(qObject, jsonObject.getJSONObject(key), false);
                        break;
                    default:
                        newPredicate = getPredicate(qObject, key, jsonObject.getJSONObject(key),isAnd);
                }

                 predicate = meargePredicate(predicate, newPredicate, isAnd);

            }
        } catch (Exception e) {
            throw new Exception("查询参数格式错误");
        } finally {
            return predicate;
        }
    }



    private static Predicate getPredicate(Object qObject, String columnName, JSONObject rangeJsonObject, boolean isAnd)  {
        Predicate predicate = null;
        try {
            for (Map.Entry<String, Object> rangeEntry : rangeJsonObject.entrySet()) {
                String key = rangeEntry.getKey();
                Field field = qObject.getClass().getField(columnName);
                predicate = meargePredicate(predicate, getPredicateByCond(field.get(qObject), key, rangeJsonObject.get(key)), isAnd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new Exception(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return predicate;
    }



    private static Predicate getPredicateByCond(Object fieldObj, String symbol, Object value) {
        Predicate predicate = null;
        try {
            if(symbol.equals("in")){
                Method method = fieldObj.getClass().getMethod(symbol,Expression[].class);
                method.setAccessible(true);
                Object[] objs = ((JSONArray) value).toArray();
                Expression[] expressions = new Expression[objs.length];
                for(int i=0;i<objs.length;i++){
                    expressions[i]= ConstantImpl.create(objs[i]);
                }
                predicate = (Predicate) method.invoke(fieldObj, (Object)expressions);
            }else {
                Method method = fieldObj.getClass().getMethod(symbol, Expression.class);
                method.setAccessible(true);
                if (fieldObj instanceof DateTimePath || fieldObj instanceof DatePath) {
                    predicate = (Predicate) method.invoke(fieldObj, ConstantImpl.create(Timestamp.valueOf(value.toString())));
                } else {
                    predicate = (Predicate) method.invoke(fieldObj, ConstantImpl.create(value));
                }
            }
        } catch (Exception e) {
            try {
                throw new Exception(fieldObj+"."+symbol+"("+value+")调用失败，请检查参数，错误原因"+e.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return predicate;
    }

    public static Predicate meargePredicate(Predicate predicate1, Predicate predicate2, boolean isAnd){
        if(isAnd){
            return ExpressionUtils.and(predicate1 ,predicate2);
        }else{
            return ExpressionUtils.or(predicate1 ,predicate2);
        }
    }

}
