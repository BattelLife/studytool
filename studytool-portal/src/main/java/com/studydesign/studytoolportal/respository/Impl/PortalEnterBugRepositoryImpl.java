package com.studydesign.studytoolportal.respository.Impl;


import com.alibaba.fastjson.JSONObject;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studydesign.studytoolbasic.contant.UserConstant;
import com.studydesign.studytoolbasic.util.ShiroUtil;
import com.studydesign.studytoolbusiness.entity.entitis.BugInfo;
import com.studydesign.studytoolportal.pojo.BugInfoPojo;
import com.studydesign.studytoolportal.respository.PortalEnterBugRepository;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.Security;
import java.sql.Timestamp;
import java.util.UUID;


@Repository
public class PortalEnterBugRepositoryImpl  implements PortalEnterBugRepository {


    @Autowired
    @Qualifier("queryFactory")
    private JPAQueryFactory queryFactory;


    @PersistenceContext(unitName = "persisteUnit")
    private EntityManager entityManager;



    @Override
    public JSONObject addBugInfo(BugInfoPojo bugInfoPojo) {
        BugInfo bugInfo = new BugInfo();
        bugInfo.setId(UUID.randomUUID().toString());
        bugInfo.setBugCreateTime(new Timestamp(System.currentTimeMillis()));
        BeanUtils.copyProperties(bugInfoPojo,bugInfo);
        String name = ((JSONObject) ShiroUtil.getSessionAttr(UserConstant.CURRENT_ARTEL)).getString("username");
        bugInfo.setBugCreator(name);
        JSONObject object = new JSONObject();
        object.put("creator",name);
        object.put("info",bugInfo.getBugDetailinfo());
        entityManager.persist(bugInfo);
        return object;

    }
}
