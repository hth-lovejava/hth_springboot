package com.combat.service;

import com.combat.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 登录方法接口
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 查询重复用户名方法接口
     * @param user
     * @return
     */
    User getnamesake(User user);

    /**
     * 向数据库中添加用户信息
     * @param user
     */
    void adduser(User user);

    /**
     * 查询全部用户信息
     * @return
     */
    List<User> list();

    /**
     * 查询用户信息方法
     * @param user
     * @return
     */
    User get_user_information(User user);


    /**
     * 修改个人信息
     * @param user
     */
    User revise_information(User user,String now_user_name);
}
