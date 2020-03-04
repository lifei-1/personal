package com.rrz.main.web.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.rrz.main.feign.ISysUserService;
import com.rrz.main.model.SysUser;

public class SysUserRealm extends AuthorizingRealm {

	@Autowired
	private ISysUserService sysUserService;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("==============执行了授权");
		return null;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userToken = (UsernamePasswordToken)token;
		if(userToken.getUsername() == null || "".equals(userToken.getUsername())){
			return null;
		}
		SysUser sysUser = sysUserService.sysUserLogin(userToken.getUsername());
		if(sysUser == null) {
			return null;
		}
		SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(sysUser.getSysUserName(),sysUser.getSysUserPassword(),getName());
		return authcInfo;
	}

}
