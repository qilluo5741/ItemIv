package com.sharebo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.MenuTypeInfo;

public interface UserService {
	// 获取用户信息
	public UserInfo getUserInfo(@Param("userAccount") String userAccount,
			@Param("userPassword") String userPassword);

	// 获取全部菜单
	public List<MenuTypeInfo> getAllMenu();
	//根据角色Id查询全部菜单
	public List<MenuTypeInfo> getAllMenuByRoleId(String roleId);
}
