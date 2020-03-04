package com.rrz.main.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rrz.main.model.SysUser;

@Component
@FeignClient(value = "${provider.security}")
public interface ISysUserService {

	String BASE = "sys/user";

	@RequestMapping(value = BASE + "/sysUserLogin", method = RequestMethod.POST)
	SysUser sysUserLogin(@RequestParam("username") String username);

}