package com.kpeee.camrentals.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kpeee.camrentals.mapper.UserMapper;
import com.kpeee.camrentals.model.User;
import com.kpeee.camrentals.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private UserMapper userMapper;


    @RequestMapping("/findById")
    public User findById(Integer id) {
        System.out.println(userService.getById(id));
        return userService.getById(id);
    }

    @GetMapping("/test")
    public User test(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return userMapper.selectOne(queryWrapper);
    }
}
