package com.sharebo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.MenuTypeInfo;

public interface UserService {
	// ��ȡ�û���Ϣ
	public UserInfo getUserInfo(@Param("userAccount") String userAccount,
			@Param("userPassword") String userPassword);

	// ��ȡȫ���˵�
	public List<MenuTypeInfo> getAllMenu();
	//���ݽ�ɫId��ѯȫ���˵�
	public List<MenuTypeInfo> getAllMenuByRoleId(String roleId);
}
