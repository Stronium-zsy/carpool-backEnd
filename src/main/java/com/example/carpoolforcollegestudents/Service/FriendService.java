package com.example.carpoolforcollegestudents.Service;

import com.example.carpoolforcollegestudents.Pojo.User;
import io.swagger.models.auth.In;

import java.util.List;

public interface FriendService {
    public List<User> findFriends(Integer userid);
}
