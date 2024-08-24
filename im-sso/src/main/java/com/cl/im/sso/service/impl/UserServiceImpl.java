package com.cl.im.sso.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.im.sso.domain.entity.UserInfo;
import com.cl.im.sso.mapper.UserMapper;
import com.cl.im.sso.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

}
