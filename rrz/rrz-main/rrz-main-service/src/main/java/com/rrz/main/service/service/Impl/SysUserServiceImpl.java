package com.rrz.main.service.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrz.main.model.SysUser;
import com.rrz.main.service.mapper.SysUserMapper;
import com.rrz.main.service.service.ISysUserService;

@Service
public class SysUserServiceImpl implements ISysUserService{
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser sysUserLogin(String username) {
		SysUser sysUserLogin = sysUserMapper.sysUserLogin(username);
		return sysUserLogin;
	}



}