package com.rrz.main.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rrz.main.model.SysUser;

@Mapper
@Repository
public interface SysUserMapper {

	List<SysUser> querySysUserList();

}
