package com.zjer.dao;

import com.zjer.entity.User;

import java.util.List;

/**
 * @author shijun
 * @date 2018/8/1 1:12
 * @param
 * @return
 */
public interface UserDao {
    //注册
    public void save(User user);

    //登录
    public User findByName(String uName);

    //修改密码
    public void updatePass(User user);

    //获取所有用户
    public List<User> findAll();

    //获取某个用户的所有信息
    public User findUser(String uName);

    //修改个人资料
    public void saveEdit(User user);
}
