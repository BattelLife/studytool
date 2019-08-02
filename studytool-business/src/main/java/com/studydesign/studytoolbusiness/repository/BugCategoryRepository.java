package com.studydesign.studytoolbusiness.repository;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.types.Predicate;
import com.studydesign.studytoolbusiness.entity.entitis.BugCategory;



/**
* BugCategoryDao
* @author autogen
* @version
* @date 2019-06-20
*/

public interface BugCategoryRepository  {

    BugCategory get(String id);

    List<BugCategory> getListByPredicate(Predicate predicate);


    void add(BugCategory bugCategory);

    void update(BugCategory bugCategory);

    long delete(String id);

    long deleteByCondition(Predicate predicate);

}
