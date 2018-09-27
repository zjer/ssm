package com.zjer.service;

import com.zjer.dao.UserDao;
import com.zjer.entity.User;
import com.zjer.util.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author shijun
 * @date 2018/8/2 0:43
 * @param
 * @return
 */
@Service("userService")//扫描Sring容器
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    //注册
    public ResultUtil<Object> addUser(String uName, String uPass) {
        //接收结果数据
        ResultUtil<Object> resultUtil = new ResultUtil<Object>();
        //检测结果是否被占用
        //1.已被占用
        User hasUser = userDao.findByName(uName);
        if (hasUser != null) {
            resultUtil.setState(1);
            resultUtil.setMsg("该用户名已存在！");
            return resultUtil;
        }
        //2.未被占用
        User user = new User();
        //设置用户名
        user.setName(uName);
        //设置密码
        user.setPass(uPass);
        //保存数据
        userDao.save(user);
        //构建返回结果
        resultUtil.setState(0);
        resultUtil.setMsg("注册成功！");
        resultUtil.setData(user);
        return resultUtil;
    }

    //登录
    public ResultUtil<User> checkLogin(String uName, String uPass) {
        //接收结果数据
        ResultUtil<User> resultUtil = new ResultUtil<User>();
        //根据name查找数据
        User user = userDao.findByName(uName);
        //检查该用户是否存在
        if (user == null) {
            resultUtil.setState(1);
            resultUtil.setMsg("用户不存在，请注册新账号！");
            return resultUtil;
        }
        //验证密码是否正确
        if (!user.getPass().equals(uPass)) {
            resultUtil.setState(2);
            resultUtil.setMsg("密码错误！");
            return resultUtil;
        }
        //用户名和密码无误
        resultUtil.setState(0);
        resultUtil.setMsg("登录成功！");
        resultUtil.setData(user);
        return resultUtil;
    }

    //修改密码
    public ResultUtil<Object> updatePassword(String uName, String uPass) {
        //接收结果数据
        ResultUtil<Object> resultUtil = new ResultUtil<Object>();
        //检测所修改的用户是否存在
        //1.该用户不存在
        User hasUser = userDao.findByName(uName);
        if (hasUser == null) {
            resultUtil.setState(1);
            resultUtil.setMsg("该用户不存在，请前往注册新账号！");
            return resultUtil;
        }
        //2.该用户存在
        User user = new User();
        //设置用户名
        user.setName(uName);
        //设置密码
        user.setPass(uPass);
        //保存更新的数据
        userDao.updatePass(user);
        //构建返回结果
        resultUtil.setState(0);
        resultUtil.setMsg("密码修改成功！");
        resultUtil.setData(user);
        return resultUtil;
    }

    //获取所有用户
    public List<User> findAllUser() {
        //接收结果数据
        List<User> list = userDao.findAll();
        return list;
    }

    //获取某个用户的所有信息
    public ResultUtil<User> findUserinfo(String uName) {
        //接收结果数据
        ResultUtil<User> resultUtil = new ResultUtil<User>();
        //根据name查找数据
        User user = userDao.findUser(uName);
        //用户名和密码无误
        resultUtil.setState(0);
        resultUtil.setMsg("获取成功！");
        resultUtil.setData(user);
        return resultUtil;
    }

    //修改个人资料
    public ResultUtil<Object> updateEdit(String uName, String uNick, String uSex, String uPlace, String uBirth) {
        //接收结果数据
        ResultUtil<Object> resultUtil = new ResultUtil<Object>();
        //检测所修改的用户是否存在
        //1.该用户不存在
        User hasUser = userDao.findByName(uName);
        if (hasUser == null) {
            resultUtil.setState(1);
            resultUtil.setMsg("该用户不存在，请前往注册新账号！");
            return resultUtil;
        }
        //2.该用户存在
        User user = new User();
        //设置用户名
        user.setName(uName);
        //设置昵称
        user.setNick(uNick);
        //设置性别
        user.setSex(uSex);
        //设置所在地
        user.setPlace(uPlace);
        //设置生日
        user.setBirth(uBirth);
        //保存更新的数据
        userDao.saveEdit(user);
        //构建返回结果
        resultUtil.setState(0);
        resultUtil.setMsg("个人资料修改成功！");
        resultUtil.setData(user);
        return resultUtil;
    }
}
