package com.rrz.main.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rrz.main.model.User;
import com.rrz.main.service.service.IUserService;

@RestController
public class UserController {
 
 @Autowired
 private IUserService userService;
 
 static final String BASE = "admin/user";
 
 @ResponseBody
 @RequestMapping(value = BASE + "findUser", method = RequestMethod.GET)
 User findUser(@RequestParam("userName") String userName, @RequestParam("password") String password) {
  return userService.findUser(userName,password);
 }

}