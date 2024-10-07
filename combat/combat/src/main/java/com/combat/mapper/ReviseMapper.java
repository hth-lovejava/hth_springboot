package com.combat.mapper;

import com.combat.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReviseMapper {

    /**
     * 修改昵称
     * @return
     */
    @Update("update combat_user set nickname = #{nickname} where user_name = #{user_name};")
    void revise_nickname(@Param("nickname") String nickname ,
                         @Param("user_name") String user_name);

    /**
     * 修改密码
     * @param password
     * @param user_name
     * @return
     */
    @Update("update combat_user set password = #{password} where user_name = #{user_name}")
    void revise_password(@Param("password") String password ,
                               @Param("user_name") String user_name);


    /**
     * 修改电话号
     * @return
     */
    @Update("update combat_user set phone_number = #{nickname} where user_name = #{user_name}")
    void revise_phone_number(@Param("phone_number") String phone_number ,
                      @Param("user_name") String user_name);

}
