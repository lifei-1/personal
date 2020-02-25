package com.rrz.main.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rrz.main.feign.IUserService;
import com.rrz.main.model.User;

@Controller
@RequestMapping("/admin")
public class UserController {
	
 @Autowired
 private IUserService userService;

 @ResponseBody
 @RequestMapping(value = "user/login", method = RequestMethod.GET)
 public User userLogin(String userName, String password) {
  User user = userService.findUser(userName, password);
  return user;
 }
}