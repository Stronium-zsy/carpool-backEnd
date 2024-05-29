package com.example.carpoolforcollegestudents.Service;

import com.example.carpoolforcollegestudents.Pojo.Result;
import com.example.carpoolforcollegestudents.Pojo.Trip;

import java.util.List;

public interface TripService {
    public List<Trip> getTrips(Integer id);
    public boolean addTrip(Trip trip);
    public List<Trip> searchallTrips(Trip trip);
    public boolean deletetrip(Integer id);
    public boolean jointrip(Integer tripId,Integer sender,Integer receiver);

}
