package com.example.carpoolforcollegestudents.Service.Impl;

import com.example.carpoolforcollegestudents.Mapper.TripMapper;
import com.example.carpoolforcollegestudents.Pojo.Result;
import com.example.carpoolforcollegestudents.Pojo.Trip;
import com.example.carpoolforcollegestudents.Utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TripServiceImpl implements com.example.carpoolforcollegestudents.Service.TripService {

    @Autowired
    private TripMapper tripMapper;
    @Override
    public List<Trip> getTrips(Integer id) {
        List<Trip> trips=tripMapper.findTripsByUserid(id);
        return trips;
    }
    @Override
    public boolean addTrip(Trip trip) {
        tripMapper.addTrip(trip);
        return true;
    }
    @Override
    public List<Trip> searchallTrips(Trip trip) {
        String departure=trip.departure;
        String destination=trip.destination;
        String startdate=trip.startDate;
        String enddate=trip.endDate;
        List<Trip> trips=tripMapper.searchallTrips(departure,destination,startdate,enddate);
        return trips;
    }
    @Override
    public boolean deletetrip(Integer id) {
        tripMapper.deletetrip(id);
        return true;
    }

    @Override
    public boolean jointrip(Integer tripId,Integer sender,Integer receiver) {
        tripMapper.joinTrip(tripId,sender,receiver);
        return true;
    }
}
