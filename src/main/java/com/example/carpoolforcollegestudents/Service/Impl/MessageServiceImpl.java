package com.example.carpoolforcollegestudents.Service.Impl;

import com.example.carpoolforcollegestudents.Mapper.MessageMapper;
import com.example.carpoolforcollegestudents.Pojo.Join_Trip;
import com.example.carpoolforcollegestudents.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper ;
    @Override
    public List<Join_Trip> findMessagesById(Integer receiver) {
        List<Join_Trip>messages=messageMapper.findMessagesById(receiver);
        return messages;
    }
    @Override
    public boolean decide(Integer decision, Integer joinid) {
        if(decision==1){
            messageMapper.decide("接受",joinid);
            return true;
        }
        else if(decision==0){
            messageMapper.decide("拒绝",joinid);
            return true;
        }
        return false;
    }

}
