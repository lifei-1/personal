package com.rrz.main.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rrz.main.feign.ISysUserService;
import com.rrz.main.model.SysUser;

@Controller
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String toMain() {
		return "main";
	}

	@RequestMapping(value = "sys/user/login", method = RequestMethod.POST)
	public String login(SysUser sysUser, Model model) {
		// 获取系统用户用户名
		String sysUserName = sysUser.getSysUserName();
		// 获取系统用户密码
		String sysUserPassword = sysUser.getSysUserPassword();
		// 添加用户认证信息
		UsernamePasswordToken token = new UsernamePasswordToken(sysUserName, sysUserPassword);
		Subject subject = SecurityUtils.getSubject();
		try {
			// 进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(token);
			return "redirect:/main";
		} catch (UnknownAccountException e) {
			model.addAttribute("msg", "用户名错误");
			return "redirect:/login";
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("msg", "密码错误");
			return "redirect:/login";
		}
	}


}