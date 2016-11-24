package com.sharebo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.MenuTypeInfo;
import com.sharebo.mapper.UserMapper;
import com.sharebo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;

	@Override
	public UserInfo getUserInfo(String userAccount, String userPassword) {
		// TODO Auto-generated method stub
		return mapper.getUserInfo(userAccount, userPassword);
	}

	@Override
	public List<MenuTypeInfo> getAllMenu() {
		// TODO Auto-generated method stub
		return mapper.getAllMenu();
	}
	@Override
	public List<MenuTypeInfo> getAllMenuByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return mapper.getAllMenuByRoleId(roleId);
	}
	
}
