package com.example.carpoolforcollegestudents.Service;

import com.example.carpoolforcollegestudents.Pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    //用户注册
    public void register(String email, String password);
    //根据用户名查询用户
    public User findByUserEmail(String email);
    public void update(User user);
    public void updateAvatar(String avatar);
}
