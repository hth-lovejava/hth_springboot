package com.combat.controller;

import com.combat.pojo.Result;
import com.combat.pojo.User;
import com.combat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class EnrollController {

    @Autowired
    private UserService userService;

    /**
     * 注册网页，必须传输用户名，昵称，来注册用户，密码初始为666666
     * @param user
     * @return
     */

    @PostMapping("/enroll")
    public Result enroll(@RequestBody User user){
        log.info("开始注册,{}",user);
        /**
         * 判断用户名，昵称，密码是否为空
         */
        if (user.getUser_name() == null){
            return Result.error("请输入用户名");
        }
        if (user.getNickname() == null){
            return Result.error("请输入昵称");
        }
        if (user.getPassword() == null){
            return Result.error("请输入密码");
        }

        /**
         * 查重命名，并添加新用户信息
         */
        User gn = userService.getnamesake(user);
        if (gn == user){
            userService.adduser(user);
            return Result.success();
        } else {
            return Result.error("用户名已存在");
        }
    }
}
