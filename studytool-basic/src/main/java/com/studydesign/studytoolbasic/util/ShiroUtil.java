package com.studydesign.studytoolbasic.util;


import org.apache.shiro.SecurityUtils;

public class ShiroUtil {
    public static Object getSessionAttr(String key){
        Object object = SecurityUtils.getSubject().getSession().getAttribute(key);
        if(object==null){
            try {
                throw new Exception("未登录，请先登录 ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  object;
    }
}
