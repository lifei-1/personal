package com.rrz.main.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rrz.main.model.User;

@Component
@FeignClient(value = "${provider.security}")
public interface IUserService {
 
 String BASE = "admin/user";

 @ResponseBody
 @RequestMapping(value = BASE + "findUser", method = RequestMethod.GET)
 User findUser(@RequestParam("userName") String userName, @RequestParam("password") String password);

}