package com.kpeee.camrentals.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kpeee.camrentals.entity.Result;
import com.kpeee.camrentals.entity.TUser;
import com.kpeee.camrentals.service.TUserService;
import com.kpeee.camrentals.utils.JwtUtil;
import com.kpeee.camrentals.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/AllUser")
    public Result getAllUser(){
        return Result.success(tUserService.list());
    }

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^1\\d{10}$") String user_phone,
                           @Pattern(regexp = "^\\S{5,16}$") String password){
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone",user_phone);
        Long CheckUser = tUserService.count(queryWrapper);


        if(CheckUser == 0){
            TUser tUser = new TUser();
            tUser.setUser_phone(user_phone);
            String md5String = Md5Util.getMD5String(password);
            tUser.setUser_email("none");
            tUser.setUesr_name("none");
            tUser.setUser_password(md5String);
            tUserService.save(tUser);
            return Result.success();
        }else{
            return Result.error("该手机号已注册");
        }
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^1\\d{10}$") String user_phone,
                        @Pattern(regexp = "^\\S{5,16}$") String password){

        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone",user_phone);
        TUser tUser = tUserService.getOne(queryWrapper);
        if (tUser == null){
            return Result.error("该手机号未注册");
        }

        if(Md5Util.getMD5String(password).equals(tUser.getUser_password())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("user_id",tUser.getUser_id());
            claims.put("user_phone",tUser.getUser_phone());
            String token = JwtUtil.getToken(claims);

            //redis
            ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
            valueOperations.set(token,token,1, TimeUnit.HOURS);


            return Result.success(token);
        }

        return Result.error("密码错误");
    }
}
