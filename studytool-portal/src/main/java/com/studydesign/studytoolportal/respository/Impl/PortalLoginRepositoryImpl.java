package com.studydesign.studytoolportal.respository.Impl;


import com.alibaba.fastjson.JSONObject;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studydesign.studytoolbasic.contant.UserConstant;
import com.studydesign.studytoolbusiness.entity.entitis.UserInfo;
import com.studydesign.studytoolbusiness.entity.q.QUserInfo;
import com.studydesign.studytoolportal.respository.PortalLoginRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PortalLoginRepositoryImpl  implements PortalLoginRepository {


    @Autowired
    @Qualifier("queryFactory")
    private JPAQueryFactory queryFactory;

    @PersistenceContext(unitName = "persisteUnit")
    private EntityManager entityManager;



    private QUserInfo userInfoQ = QUserInfo.userInfo;


    @Override
    public int login(String username, String password) {
        UserInfo userInfo  =  queryFactory.selectFrom(userInfoQ)
                .where(userInfoQ.userName.eq(username),userInfoQ.userPassword.eq(password)).fetchOne();
        String userId = userInfo.getId();
        JSONObject object = new JSONObject();
        object.put("username",userInfo.getUserName());
        UsernamePasswordToken passwordToken = new UsernamePasswordToken(userId,userId);
        Subject subject = SecurityUtils.getSubject();
        subject.login(passwordToken);
        Session session = subject.getSession();
        session.setAttribute(UserConstant.CURRENT_ARTEL, object);
        if (userInfo!=null){
            return 1;
        }else {
            return 0;
        }
    }

}
