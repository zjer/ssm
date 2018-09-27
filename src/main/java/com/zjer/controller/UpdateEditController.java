package com.zjer.controller;

import com.zjer.service.UserService;
import com.zjer.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * @author shijun
 * @date 2018/8/17 0:18
 * @param
 * @return
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/user")
public class UpdateEditController {
    @Resource
    private UserService userService;

    @RequestMapping("/updateUser.do")
    @ResponseBody
    public ResultUtil<Object> execute(String uName, String uNick, String uSex, String uPlace, String uBirth) {
        System.out.println("name:" +uName + " , nick:" + uNick + " , sex:" + uSex + " , city:" + uPlace + " , birth:" + uBirth);
        //调用UserService处理登录请求
        ResultUtil<Object> resultUtil = userService.updateEdit(uName, uNick, uSex, uPlace, uBirth);
        return resultUtil;
    }
}
