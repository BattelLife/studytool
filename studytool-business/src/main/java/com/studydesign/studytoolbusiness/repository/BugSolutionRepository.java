package com.studydesign.studytoolbusiness.repository;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.types.Predicate;
import com.studydesign.studytoolbusiness.entity.entitis.BugSolution;



/**
* BugSolutionDao
* @author autogen
* @version
* @date 2019-06-20
*/

public interface BugSolutionRepository  {

    BugSolution get(String id);

    List<BugSolution> getListByPredicate(Predicate predicate);


    void add(BugSolution bugSolution);

    void update(BugSolution bugSolution);

    long delete(String id);

    long deleteByCondition(Predicate predicate);

}
