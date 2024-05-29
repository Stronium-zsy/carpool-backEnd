package com.example.carpoolforcollegestudents.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class User {
    @NonNull
    private Integer id;
    @NotEmpty
    private String username;
    @NotEmpty
    @Pattern(regexp = "^\\S{5,16}$",message = "密码格式错误")
    private String password;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$",message = "昵称格式错误")
    private String nickname;
    @NotEmpty
    @Email
    private String email;
    private String userpic;
    private Timestamp createtime;
    private Timestamp updatetime;
}
