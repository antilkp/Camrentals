package com.kpeee.camrentals.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kpeee.camrentals.model.User;
import com.kpeee.camrentals.service.UserService;
import com.kpeee.camrentals.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author lkp
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-03-13 14:33:20
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




