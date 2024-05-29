package com.example.carpoolforcollegestudents.Mapper;

import com.example.carpoolforcollegestudents.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FriendMapper {

    @Select("SELECT u.* FROM user u JOIN friend f ON u.id = f.friendid WHERE f.id = #{id}")
    public List<User> findFriendsByUserid(@Param("id")Integer userid);

}
