package com.example.carpoolforcollegestudents.Service.Impl;

import com.example.carpoolforcollegestudents.Mapper.FriendMapper;
import com.example.carpoolforcollegestudents.Mapper.UserMapper;
import com.example.carpoolforcollegestudents.Pojo.User;
import com.example.carpoolforcollegestudents.Service.FriendService;
import com.example.carpoolforcollegestudents.Utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;



@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Override
    public List<User> findFriends(Integer userid) {
        List<User> friends=friendMapper.findFriendsByUserid(userid);
        return friends;
    }

}
