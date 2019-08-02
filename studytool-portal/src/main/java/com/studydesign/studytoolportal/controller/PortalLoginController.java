package com.studydesign.studytoolportal.controller;

import com.studydesign.studytoolbusiness.entity.entitis.UserInfo;
import com.studydesign.studytoolportal.service.PortalLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"用户登录管理"})
@RequestMapping("/index")
public class PortalLoginController {

    @Autowired
    private PortalLoginService portalLoginService;

    @ApiOperation("用户登录")
    @GetMapping("/login")
    @ResponseBody
    public int login(String username,String password){
        return portalLoginService.login(username,password);
    }


    @ApiOperation("用户注册")
    @GetMapping("/registe")
    @ResponseBody
    public String registerAccount(UserInfo userInfo){
        return portalLoginService.registerAccount(userInfo);
    }

}
