package com.studydesign.studytoolbusiness.repository;

import java.util.List;

import com.querydsl.core.types.Predicate;
import com.studydesign.studytoolbusiness.entity.entitis.UserInfo;



/**
* UserInfoDao
* @author autogen
* @version
* @date 2019-06-20
*/

public interface UserInfoRepository  {

    UserInfo get(String id);

    List<UserInfo> getListByPredicate(Predicate predicate);
    int add(UserInfo userInfo);

    int update(UserInfo userInfo);

    long delete(String id);

    long deleteByCondition(Predicate predicate);

}
