package com.example.carpoolforcollegestudents.Service.Impl;

import com.example.carpoolforcollegestudents.Mapper.UserMapper;
import com.example.carpoolforcollegestudents.Pojo.User;
import com.example.carpoolforcollegestudents.Service.UserService;
import com.example.carpoolforcollegestudents.Utils.PasswordEncoderUtil;
import com.example.carpoolforcollegestudents.Utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public void register(String email, String password) {
        String encodePassword= PasswordEncoderUtil.encodePassword(password);
        Timestamp now = new Timestamp(new Date().getTime());
        userMapper.add(email,encodePassword,now.toString(),now.toString());
    }

    @Override
    public User findByUserEmail(String email) {
        User u=userMapper.findByUserName(email);
        return u;
    }

    @Override
    public void update(User user){
        user.setUpdatetime(new Timestamp(new Date().getTime()));
        userMapper.update(user);
    }
    @Override
    public void updateAvatar(String avatarUrl){
        Timestamp now = new Timestamp(new Date().getTime());
        Map<String,Object> claims= ThreadLocalUtil.get();
        String email=(String)claims.get("email");
        userMapper.updateAvatar(avatarUrl,now,email);
    }
}
