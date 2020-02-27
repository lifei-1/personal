package com.rrz.main.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rrz.main.model.SysUser;

@Component
@FeignClient(value = "${provider.security}")
public interface ISysUserService {
 
 String BASE = "sys/user";

 @ResponseBody
 @RequestMapping(value = BASE + "/querySysUserList", method = RequestMethod.GET)
 List<SysUser> querySysUserList();

}