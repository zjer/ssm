package com.zjer.controller;

import com.zjer.entity.User;
import com.zjer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/user")
public class FindAllController {
    @Resource
    private UserService userService;

    @RequestMapping("/findAll.do")
    @ResponseBody
    public List<User> execute() {
        //调用UserService处理登录请求
        List<User> list = userService.findAllUser();
        return list;
    }
}
