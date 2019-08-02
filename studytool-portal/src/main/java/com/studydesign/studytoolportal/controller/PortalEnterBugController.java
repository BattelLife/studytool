package com.studydesign.studytoolportal.controller;


import com.alibaba.fastjson.JSONObject;
import com.studydesign.studytoolbusiness.entity.entitis.BugCategory;
import com.studydesign.studytoolportal.pojo.BugInfoPojo;
import com.studydesign.studytoolportal.service.PortalEnterBugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"BUG信息管理"})
public class PortalEnterBugController {

    @Autowired
    private PortalEnterBugService portalEnterBugService;



    @PostMapping("/addBugInfo")
    @ApiOperation("新增bug信息")
    @ResponseBody
    public JSONObject addBugInfo(@RequestBody BugInfoPojo bugInfoPojo){
        return portalEnterBugService.addBugInfo(bugInfoPojo);
    }







    @GetMapping("/getBugCategory")
    @ApiOperation("获取所有的bug类别")
    public List<BugCategory> getBugCategorg(){
        return null;
    }


}
