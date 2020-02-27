package com.rrz.main.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rrz.main.model.SysUser;
import com.rrz.main.service.service.ISysUserService;

@RestController
public class SysUserController {
 
 @Autowired
 private ISysUserService sysUserService;
 
 static final String BASE = "sys/user";
 
 @ResponseBody
 @RequestMapping(value = BASE + "/querySysUserList", method = RequestMethod.GET)
 List<SysUser> querySysUserList(){
	 return sysUserService.querySysUserList();
 }

}