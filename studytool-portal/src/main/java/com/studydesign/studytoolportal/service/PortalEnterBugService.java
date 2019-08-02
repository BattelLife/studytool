package com.studydesign.studytoolportal.service;


import com.alibaba.fastjson.JSONObject;
import com.studydesign.studytoolportal.pojo.BugInfoPojo;

public interface PortalEnterBugService {
    JSONObject addBugInfo(BugInfoPojo bugInfoPojo);
}
