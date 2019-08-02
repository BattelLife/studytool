package com.studydesign.studytoolportal.respository;


import com.studydesign.studytoolbusiness.entity.entitis.UserInfo;

public interface PortalLoginRepository {
    int login(String username, String password);

}
