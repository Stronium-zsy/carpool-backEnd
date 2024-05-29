package com.example.carpoolforcollegestudents.Controller;

import com.example.carpoolforcollegestudents.Pojo.Result;
import com.example.carpoolforcollegestudents.Pojo.User;
import com.example.carpoolforcollegestudents.Service.UserService;
import com.example.carpoolforcollegestudents.Utils.JwtUtil;
import com.example.carpoolforcollegestudents.Utils.PasswordEncoderUtil;
import com.example.carpoolforcollegestudents.Utils.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated
@CrossOrigin(origins="http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate  stringRedisTemplate;

    @GetMapping("/userInfo")
    public Result<User> userInfo() {

        Map<String,Object> claims= ThreadLocalUtil.get();
        String email=(String)claims.get("email");
        User u=userService.findByUserEmail(email);
        return Result.success(u);

    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){

        Map<String,Object> claims= ThreadLocalUtil.get();
        String email=(String)claims.get("email");
        user.setEmail(email);
        userService.update(user);
        return Result.success();

    }


    @PostMapping("/register")
    public Result register(@Email String email,@Pattern(regexp="^\\S{5,16}$") String password) {

            User u = userService.findByUserEmail(email);

            if (u == null) {
                userService.register(email, password);
                return Result.success();
            } else {
                return Result.error("注册失败");
            }

    }

    @PostMapping("/login")
    public Result login(@Email String email, @Pattern(regexp="^\\S{5,16}$") String password){

        User u=userService.findByUserEmail(email);

        if(u!=null){
            System.out.println(u.toString());
            if(PasswordEncoderUtil.matches(password,u.getPassword())){


//                String token=JwtUtil.genToken(claims);
//                ValueOperations<String,String>operations=stringRedisTemplate.opsForValue();
//                operations.set(token,token,24, TimeUnit.HOURS);
                Map<String, Object> responseData = new HashMap<>();
//                responseData.put("token", token);

                responseData.put("id",u.getId());
                responseData.put("username",u.getUsername());
                responseData.put("email",u.getEmail());
                return Result.success(responseData);

            }else{

                return Result.error("密码错误");

            }
        }else{
            return Result.error("用户不存在");
        }

    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){

        Map<String,Object> claims= ThreadLocalUtil.get();
        String email=(String)claims.get("email");
        User u=userService.findByUserEmail(email);
        userService.updateAvatar(avatarUrl);
        return Result.success();

    }

}
