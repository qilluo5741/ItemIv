package com.sharebo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sharebo.entity.dto.UserDto;
import com.sharebo.mapper.UserDtoMapper;
import com.sharebo.service.UserDtoService;
@Service
public class UserDtoServiceImpl implements UserDtoService {
	@Autowired
	private UserDtoMapper mapper;
	@Override
	public int addUser(UserDto user) {
		return mapper.addUser(user);
	}

	@Override
	public int updatecancellationUser(String userid) {
		return mapper.updatecancellationUser(userid);
	}

	@Override
	public int updateModifyUser(String userAccount,String userid) {
		return mapper.updateModifyUser(userAccount,userid);
	}

	@Override
	public List<UserDto> getselectUserlist(Map<String, Object> map) {
		return mapper.getselectUserlist(map);
	}

	@Override
	public int selectUserlistCount() {
		return mapper.selectUserlistCount();
	}
	@Override
	public int valserialuserAccountIsExists(String userAccount) {
		return mapper.valserialuserAccountIsExists(userAccount);
	}

	@Override
	public int addRoleInfo(String userid) {
		return mapper.addRoleInfo(userid);
	}

	@Override
	public String seleclroleByuserId(String userAccount) {
		return mapper.seleclroleByuserId(userAccount);
	}

	@Override
	public String valserialuserAccountandoldpasswordIsExists(String userAccount, String userPassword) {
		return mapper.valserialuserAccountandoldpasswordIsExists(userAccount, userPassword);
	}

	@Override
	public int updateModifyuserPwdUser(String userPassword, String userid) {
		return mapper.updateModifyuserPwdUser(userPassword, userid);
	}
}
