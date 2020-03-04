package com.rrz.main.web.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
	
	//1.创建realm对象
	@Bean(name = "sysUserRealm")
	public SysUserRealm sysUserRealm() {
		return new SysUserRealm();
	}
	

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("sysUserRealm")SysUserRealm sysUserRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//关联userrealm
		securityManager.setRealm(sysUserRealm);
		return securityManager;
	}
	
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);
		Map<String,String> filterMap = new LinkedHashMap<String,String>();
//		filterMap.put("/sys/user/querySysUserList", "authc");
		//登录
//		factoryBean.setLoginUrl("/sys/user/login");
		factoryBean.setFilterChainDefinitionMap(filterMap);
		return factoryBean;
	}
}
