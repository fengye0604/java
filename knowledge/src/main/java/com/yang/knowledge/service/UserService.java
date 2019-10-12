package com.yang.knowledge.service;

import com.yang.knowledge.bean.User;
import com.yang.knowledge.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User addUser(User user){
       int count =  userMapper.insert(user);
    return user;
    }
}
