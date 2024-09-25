package com.combat.controller;

import com.combat.pojo.Result;
import com.combat.pojo.User;
import com.combat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/users")
@RestController
public class UsersController {
    @Autowired
    private UserService userService;


    /**
     * 查询全部用户网页
     * @return
     */
    @GetMapping
    public Result list(){
        log.info("查询全部用户");
        List<User> usersList =  userService.list();
        return Result.success(usersList);
    }

    /**
     * 通过用户名,查询信息网页
     * @param user_name
     * @return
     */
    @GetMapping("/{user_name}")
    public Result get_user_information(@PathVariable String user_name){
        User username = new User();
        username.setUser_name(user_name);
        log.info("查询用户：{}",username);
        User user_information = userService.get_user_information(username);
        if (user_information == null){
            return Result.error("没有该用户");
        }else {
            return Result.success(user_information);
        }


    }


    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @PostMapping("/{user_name}")
    public Result revise_information(
            @PathVariable String user_name,
            @RequestBody User user){
        log.info("修改个人信息,{}",user);
        userService.revise_information(user,user_name);


    }


}
