package com.studydesign.studytoolportal.respository;

import com.alibaba.fastjson.JSONObject;
import com.studydesign.studytoolportal.pojo.BugInfoPojo;

public interface PortalEnterBugRepository {
    JSONObject addBugInfo(BugInfoPojo bugInfoPojo);
}
