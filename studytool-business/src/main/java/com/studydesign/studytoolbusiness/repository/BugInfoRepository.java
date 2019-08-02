package com.studydesign.studytoolbusiness.repository;

import java.util.List;
import com.querydsl.core.types.Predicate;
import com.studydesign.studytoolbusiness.entity.entitis.BugInfo;



/**
* BugInfoDao
* @author autogen
* @version
* @date 2019-06-20
*/

public interface BugInfoRepository  {

    BugInfo get(String id);

    List<BugInfo> getListByPredicate(Predicate predicate);


    void add(BugInfo bugInfo);

    void update(BugInfo bugInfo);

    long delete(String id);

    long deleteByCondition(Predicate predicate);

}
