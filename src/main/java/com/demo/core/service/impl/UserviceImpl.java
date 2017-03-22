package com.demo.core.service.impl;

import org.springframework.stereotype.Service;

import com.demo.core.entity.User;
import com.demo.core.service.UserService;

@Service("userService")
public class UserviceImpl extends BaseServiceImpl<User> implements UserService {
}
