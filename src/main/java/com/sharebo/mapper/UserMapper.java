package com.sharebo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.MenuTypeInfo;

public interface UserMapper {
	//��ȡ�û���Ϣ
	public UserInfo getUserInfo(@Param("userAccount")String userAccount,@Param("userPassword")String userPassword);
	//��ȡȫ���˵�
	public List<MenuTypeInfo> getAllMenu();
	//���ݽ�ɫId��ѯȫ���˵�
	public List<MenuTypeInfo> getAllMenuByRoleId(@Param("roleId")String roleId);
	
}
