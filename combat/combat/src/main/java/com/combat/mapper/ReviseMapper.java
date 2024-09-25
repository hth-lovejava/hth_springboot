package com.combat.mapper;

import com.combat.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReviseMapper {

    /**
     * 修改昵称
     * @return
     */
    @Update("update combat_user set nickname = #{user_name} where nickname = #{old_user_name};")
    User revise_nickname(@Param("user_name") String user_name ,
                         @Param("old_user_name") String old_user_name);

    /**
     * 修改电话号
     * @return
     */
    User phone_number();

}
