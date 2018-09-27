package com.zjer.service;

import com.zjer.entity.User;
import com.zjer.util.ResultUtil;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author shijun
 * @date 2018/8/1 23:23
 * @param
 * @return
 */
public interface UserService {
    //注册模块
    public ResultUtil<Object> addUser(String uName, String uPass);

    //登录模块
    public ResultUtil<User> checkLogin(String uName, String uPass);

    //修改密码
    public ResultUtil<Object> updatePassword(String uName, String uPass);

    //获取所有用户
    public List<User> findAllUser();

    //获取某个用户的所有信息
    public ResultUtil<User> findUserinfo(String uName);

    //修改个人资料
    public ResultUtil<Object> updateEdit(String uName, String uNick, String uSex, String uPlace, String uBirth);
}
