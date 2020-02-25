package com.rrz.main.service.service.Impl;

import org.springframework.stereotype.Service;

import com.rrz.main.model.User;
import com.rrz.main.service.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

 @Override
 public User findUser(String userName, String password) {
  User user = new User();
  user.setUserName("张三");
  user.setPassword("123456");
  return user;
 }

}