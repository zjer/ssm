package com.zjer.controller;

import com.zjer.entity.User;
import com.zjer.service.UserService;
import com.zjer.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author shijun
 * @date 2018/8/16 16:42
 * @param
 * @return
*/
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/user")
public class FindUserinfoController {
    @Resource
    private UserService userService;

    @RequestMapping("/findUserinfo.do")
    @ResponseBody
    public ResultUtil<User> execute(String uName) {
        System.out.println(uName);
        //调用UserService处理登录请求
        ResultUtil<User> resultUtil = userService.findUserinfo(uName);
        return resultUtil;
    }
}
