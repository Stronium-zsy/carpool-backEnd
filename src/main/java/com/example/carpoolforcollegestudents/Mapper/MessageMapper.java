package com.example.carpoolforcollegestudents.Mapper;

import com.example.carpoolforcollegestudents.Pojo.Join_Trip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT jt.*, t.*, u.username " +
            "FROM join_trip jt " +
            "RIGHT JOIN trip t ON jt.tripId = t.tripId " +
            "LEFT JOIN user u ON jt.sender = u.id " +
            "WHERE jt.receiver = #{receiver}")
    public List<Join_Trip> findMessagesById(@Param("receiver") Integer receiver);
    @Update("UPDATE join_trip SET status = #{status} WHERE joinid = #{joinid}")
    public void decide(@Param("status") String status, @Param("joinid") Integer joinid);


}

