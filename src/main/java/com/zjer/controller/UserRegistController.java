package com.zjer.controller;

import com.zjer.service.UserService;
import com.zjer.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author shijun
 * @date 2018/8/2 0:48
 * @param 
 * @return 
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/user")
public class UserRegistController {
    @Resource
    private UserService userService;

    @RequestMapping("/regist.do")
    @ResponseBody
    public ResultUtil<Object> execute(String uName, String uPass) {
        System.out.println("name:" +uName + " , pass:" + uPass);
        //调用UserService处理登录请求
        ResultUtil<Object> resultUtil = userService.addUser(uName, uPass);
        return resultUtil;
    }
}
