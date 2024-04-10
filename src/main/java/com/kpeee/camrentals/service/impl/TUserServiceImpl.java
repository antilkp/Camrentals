package com.kpeee.camrentals.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kpeee.camrentals.entity.TUser;
import com.kpeee.camrentals.service.TUserService;
import com.kpeee.camrentals.mapper.TUserMapper;
import org.springframework.stereotype.Service;

/**
* @author lkp
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-04-11 00:01:24
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService{

}




