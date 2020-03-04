package com.rrz.main.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rrz.main.model.SysUser;
import com.rrz.main.service.service.ISysUserService;

@RestController
public class SysUserController {

	static final String BASE = "sys/user";

	@Autowired
	private ISysUserService sysUserService;

	@RequestMapping(value = BASE + "/sysUserLogin", method = RequestMethod.POST)
	public SysUser sysUserLogin(@RequestParam("username") String username) {
		return sysUserService.sysUserLogin(username);
	}
}