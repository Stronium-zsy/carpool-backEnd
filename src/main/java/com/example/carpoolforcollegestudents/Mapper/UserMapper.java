package com.example.carpoolforcollegestudents.Mapper;

import com.example.carpoolforcollegestudents.Pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;

@Mapper
public interface UserMapper {
    @Insert("insert into user(email,password,createtime,updatetime) values (#{email},#{password},#{createtime},#{updatetime})")
    public void add(@Param("email") String  email,@Param("password") String password,@Param("createtime") String createtime,@Param("updatetime") String updatetime);
    @Select("select* from user where email=#{email}")
    public User findByUserName(@Param("email") String email);

    @Update("update user set nickname=#{nickname},userpic=#{userpic},updatetime=#{updatetime} where email=#{email}")
    public void update( User user);
    @Update("update user set userpic=#{avatarurl},updatetime=#{updatetime} where email=#{email}")
    public void updateAvatar(@Param("avatarurl")String avatarurl, @Param("updatetime")Timestamp updatetime,@Param("email") String email);
}
