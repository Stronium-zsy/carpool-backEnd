package com.example.carpoolforcollegestudents.Mapper;

import com.example.carpoolforcollegestudents.Pojo.Trip;
import com.example.carpoolforcollegestudents.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TripMapper {
    @Select("select* from trip where userid=#{userid}")
    public List<Trip> findTripsByUserid(@Param("userid")Integer userid);
    @Insert("insert into trip(departure,destination,startDate,endDate,tripName,tripId,userId,numberofpeople) " +
            "values(#{departure},#{destination},#{startDate},#{endDate},#{tripName},#{tripId},#{userId},#{numofpeople})")
    public void addTrip(Trip trip);
    @Select("SELECT * FROM trip WHERE #{departure} LIKE CONCAT('%', departure, '%') AND #{destination} LIKE CONCAT('%', destination, '%')")
    List<Trip> searchallTrips(@Param("departure") String departure, @Param("destination") String destination, @Param("startDate") String startDate, @Param("endDate") String endDate);

    @Select("delete from trip where tripId=#{tripId}")
    public void deletetrip(@Param("tripId")Integer tripId);

    @Insert("insert into join_trip(tripId,sender,receiver) values(#{tripId},#{sender},#{receiver})")
    public void joinTrip(@Param("tripId")Integer tripId,@Param("sender")Integer sender,@Param("receiver")Integer receiver);



}
