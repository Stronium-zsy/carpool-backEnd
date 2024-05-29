package com.example.carpoolforcollegestudents.Controller;

import com.example.carpoolforcollegestudents.Pojo.Result;
import com.example.carpoolforcollegestudents.Pojo.Trip;
import com.example.carpoolforcollegestudents.Service.Impl.TripServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:5173",methods={RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/trip")
@Validated

public class TripController {

    @Autowired
    private TripServiceImpl tripServiceImpl;

    @PostMapping("/addTrip")
    public Result addTrip(@RequestBody @Validated Trip trip){

        boolean ret=tripServiceImpl.addTrip(trip);

        return Result.success(ret);

    }
    @PostMapping("/searchallTrips")
    public Result searchallTrips(@RequestBody @Validated Trip trip){

        List<Trip> trips=tripServiceImpl.searchallTrips(trip);

        if(trips.size()>0){
            return Result.success(trips);
        }
        else{
            return Result.error("没有行程");
        }
    }

    @GetMapping("/getTrips")
    public Result getTrips(Integer id) {
        System.out.println(id);

        List<Trip> trips=tripServiceImpl.getTrips(id);

        if(trips.size()>0){
            return Result.success(trips);
        }
        else{
            return Result.error("没有行程");
        }
    }
    @PostMapping("/deletetrip")
    public Result deletetrip(@Param("tripid") Integer id){
        tripServiceImpl.deletetrip(id);
        return Result.success();
    }
    @PostMapping("/jointrip")
    public Result jointrip(@RequestBody Map<String, Integer> request) {
        Integer tripid = request.get("tripid");
        Integer sender = request.get("sender");
        Integer receiver = request.get("receiver");

        boolean ret = tripServiceImpl.jointrip(tripid, sender, receiver);
        return Result.success(ret);
    }

}
