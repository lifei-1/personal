package com.rrz.main.model;

import java.util.Date;

public class SysUser {

	private int sysUserId;
	private String sysUserName;
	private String sysUserPassword;
	private Date createTime;
	private Date editTime;
	private Integer isDel;

	public int getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(int sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getSysUserPassword() {
		return sysUserPassword;
	}

	public void setSysUserPassword(String sysUserPassword) {
		this.sysUserPassword = sysUserPassword;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}