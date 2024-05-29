package com.example.carpoolforcollegestudents.Controller;

import com.example.carpoolforcollegestudents.Pojo.Join_Trip;
import com.example.carpoolforcollegestudents.Pojo.Result;
import com.example.carpoolforcollegestudents.Service.Impl.MessageServiceImpl;
import io.swagger.models.auth.In;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@Validated
@CrossOrigin(origins="http://localhost:5173")

public class MessageController {

    @Autowired
    private MessageServiceImpl friendServiceImpl;
    @GetMapping("/getMessages")
    public Result getMessages(Integer userid){
        List<Join_Trip> messages=friendServiceImpl.findMessagesById(userid);
        System.out.println(messages);
        return Result.success(messages);

    }
    @PostMapping("/decide")
    public Result decide(@Param("joinid") Integer joinid, @Param("decision") Integer decision) {
        boolean ret=friendServiceImpl.decide(decision,joinid);
        return Result.success(ret);
    }
    @Data
    public class DecisionRequest {
        private String decision;
        private String joinid;

        // 省略 getter 和 setter 方法
    }




}


