package com.combat.controller;

import com.combat.pojo.Result;
import com.combat.pojo.User;
import com.combat.service.UserService;
import com.combat.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("员工登录: {}", user);
        User u = userService.login(user);

        //登录成功，发放令牌
        if (u != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("user_name", u.getUser_name());
            claims.put("password", u.getPassword());

            String jwt = JwtUtils.get_jwt(claims);

            return Result.success(jwt);
        }else {
            //登录失败，返回错误信息
            return Result.error("用户名或密码错误");
        }


    }

}
