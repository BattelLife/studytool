package com.studydesign.studytoolportal.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.studydesign.studytoolportal.pojo.BugInfoPojo;
import com.studydesign.studytoolportal.respository.PortalEnterBugRepository;
import com.studydesign.studytoolportal.service.PortalEnterBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PortalEnterBugServiceImpl implements PortalEnterBugService {


    @Autowired
    private PortalEnterBugRepository portalEnterBugRepository;


    @Transactional("transactionManager")
    @Override
    public JSONObject addBugInfo(BugInfoPojo bugInfoPojo) {
        return portalEnterBugRepository.addBugInfo(bugInfoPojo);
    }
}
