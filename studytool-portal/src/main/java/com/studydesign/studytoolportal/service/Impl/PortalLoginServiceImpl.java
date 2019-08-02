package com.studydesign.studytoolportal.service.Impl;


import com.studydesign.studytoolbusiness.entity.entitis.UserInfo;
import com.studydesign.studytoolbusiness.repository.UserInfoRepository;
import com.studydesign.studytoolbusiness.repository.impl.UserInfoRepositoryImpl;
import com.studydesign.studytoolportal.respository.PortalLoginRepository;
import com.studydesign.studytoolportal.service.PortalLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class PortalLoginServiceImpl implements PortalLoginService {

    @Autowired
    private PortalLoginRepository portalLoginRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Transactional("transactionManager")
    @Override
    public int login(String username, String password) {
        return portalLoginRepository.login(username, password);
    }


    @Transactional("transactionManager")
    @Override
    public String registerAccount(UserInfo userInfo) {
        String registMessage = null;
        String userId = UUID.randomUUID().toString();
        userInfo.setId(userId);
        if (userInfoRepository.add(userInfo) == 1) {
            registMessage = "注册成功!";
        } else {
            registMessage = "注册失败!";
        }
        return registMessage;
    }


}
