package com.studydesign.studytoolportal.service;


import com.studydesign.studytoolbusiness.entity.entitis.UserInfo;

public interface PortalLoginService {
    int login(String username, String password);

    String registerAccount(UserInfo userInfo);
}
