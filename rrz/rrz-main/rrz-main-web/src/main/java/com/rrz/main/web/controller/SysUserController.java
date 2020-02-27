package com.rrz.main.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rrz.main.feign.ISysUserService;
import com.rrz.main.model.SysUser;

@Controller
@RequestMapping("sys")
public class SysUserController {
	
 @Autowired
 private ISysUserService sysUserService;

 @ResponseBody
 @RequestMapping(value = "user/querySysUserList", method = RequestMethod.GET)
 public List<SysUser> querySysUserList() {
  List<SysUser> sysUserList = sysUserService.querySysUserList();
  return sysUserList;
 }
}