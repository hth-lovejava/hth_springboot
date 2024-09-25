package com.combat.controller;

import com.combat.pojo.Result;
import com.combat.pojo.User;
import com.combat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("员工登录: {}", user);
        User u = userService.login(user);
        return u != null?Result.success():Result.error("用户名或密码错误");
    }

}
