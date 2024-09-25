package com.combat.service.impl;

import com.combat.mapper.AddMapper;
import com.combat.mapper.LnquireMapper;
import com.combat.pojo.User;
import com.combat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private LnquireMapper lnquireMapper;
    @Autowired
    private AddMapper addMapper;


    /**
     * 登录方法，并通过用户名和密码查询
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return lnquireMapper.getByUsernameAndPassword(user);
    }

    /**
     * 查询重命名方法
     * @param user
     * @return
     */
    @Override
    public User getnamesake(User user) {
        User ung = lnquireMapper.use_name_getuser(user);
        if (ung == null ){
            return user;
        }else {
            return null;
        }

    }

    /**
     * 添加新用户方法
     * @param user
     */
    @Override
    public void adduser(User user) {
        addMapper.adduser(user);
        return;
    }

    /**
     * 查询全部用户信息
     * @return
     */
    @Override
    public List<User> list() {
        return lnquireMapper.get_all_users();
    }

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    @Override
    public User get_user_information(User user) {
        User ung = lnquireMapper.use_name_getuser(user);
        if (ung == null){
            return null;
        }else {
            return ung;
        }

    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @Override
    public User revise_information(User user , String now_user_name) {

    }


}
