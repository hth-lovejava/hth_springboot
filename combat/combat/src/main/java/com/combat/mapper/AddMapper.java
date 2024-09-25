package com.combat.mapper;

import com.combat.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddMapper {

    /**
     * 向数据库添加新用户信息
     * @param user
     * @return
     */

    @Insert("insert into combat_user(user_name, nickname, password) values (#{user_name},#{nickname},#{password})")
    void adduser(User user);
}
