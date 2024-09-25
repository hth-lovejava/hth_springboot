package com.combat.mapper;

import com.combat.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface LnquireMapper {
    /**
     * 查询全部用户信息
     * @return
     */
    @Select("select * from combat_user")
    List<User>get_all_users();


    /**
     * 通过用户名来查询是否存在重复用户名的用户
     * @param user
     * @return
     */
    @Select("select * from combat_user where user_name = #{user_name}")
    User use_name_getuser(User user);


    /**
     * 通过用户名或手机号，和密码来查询数据库中是否存在该用户
     * @param user
     * @return
     */
    @Select("select * from combat_user where user_name = #{user_name} and password = #{password}")
    User getByUsernameAndPassword(User user);
}
