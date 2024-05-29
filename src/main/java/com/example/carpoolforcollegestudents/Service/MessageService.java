package com.example.carpoolforcollegestudents.Service;

import com.example.carpoolforcollegestudents.Pojo.Join_Trip;
import io.swagger.models.auth.In;

import java.util.List;

public interface MessageService {
    public List<Join_Trip> findMessagesById(Integer receiver);
    public boolean decide(Integer decision, Integer joinid);
}
