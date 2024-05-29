package com.example.carpoolforcollegestudents.Controller;

import com.example.carpoolforcollegestudents.Pojo.Result;
import com.example.carpoolforcollegestudents.Pojo.User;
import com.example.carpoolforcollegestudents.Service.Impl.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
@Validated
@CrossOrigin(origins="http://localhost:5173")

public class FriendController {

@Autowired
private FriendServiceImpl friendServiceImpl;
@GetMapping("/findFriends")
public Result findFriends(Integer userid){
    List<User> friends=friendServiceImpl.findFriends(userid);
    if(friends.size()>0){
        return Result.success(friends);
    }
    else{
        return Result.error("没有好友");
    }
}



}
