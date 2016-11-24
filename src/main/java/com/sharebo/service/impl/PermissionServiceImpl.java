package com.sharebo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.ChildUserInfo;
import com.sharebo.entity.dto.MenusDto;
import com.sharebo.entity.dto.RoleInfo;
import com.sharebo.mapper.PermissionMapper;
import com.sharebo.service.PermissionService;
/**
 * 权限管理服务
 * @author niewei
 *
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper mapper;
	@Override
	public List<RoleInfo> getRolesByUserId(String userId) {
		// TODO Auto-generated method stub
		return mapper.getRolesByUserId(userId);
	}
	@Override
	public int getRoleCount(String userId, String roleName) {
		// TODO Auto-generated method stub
		return mapper.getRoleCount(userId, roleName);
	}
	@Override
	public int addRole(RoleInfo role) {
		// TODO Auto-generated method stub
		return mapper.addRole(role);
	}
	@Override
	public int getUserCountByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return mapper.getUserCountByRoleId(roleId);
	}
	@Override
	public int updateRoleIsDeleteByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return mapper.updateRoleIsDeleteByRoleId(roleId);
	}
	@Override
	public int updateRoleNameByroleId(String roleId, String roleName) {
		// TODO Auto-generated method stub
		return mapper.updateRoleNameByroleId(roleId, roleName);
	}
	@Override
	public int valRoleUserIsExists(String roleId, String userId) {
		// TODO Auto-generated method stub
		return mapper.valRoleUserIsExists(roleId, userId);
	}
	@Override
	public List<MenusDto> getExistsMenusByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return mapper.getExistsMenusByRoleId(roleId);
	}
	@Override
	public List<MenusDto> getNotExistsMenusByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return mapper.getNotExistsMenusByRoleId(roleId);
	}
	@Override
	public int getMenuIsFicedByMenuId(String menuId) {
		// TODO Auto-generated method stub
		return mapper.getMenuIsFicedByMenuId(menuId);
	}
	@Override
	public int getRoleMenuIsExistsByRoleIdAndMenuId(String roleId, String menuId) {
		// TODO Auto-generated method stub
		return mapper.getRoleMenuIsExistsByRoleIdAndMenuId(roleId, menuId);
	}
	@Override
	public int addRolemeun(String roleId, String menuId) {
		// TODO Auto-generated method stub
		return mapper.addRolemeun(roleId, menuId);
	}
	@Override
	public int removeRolemeunByRoleIdAndMenuId(String roleId, String menuId) {
		// TODO Auto-generated method stub
		return mapper.removeRolemeunByRoleIdAndMenuId(roleId, menuId);
	}
	@Override
	public int createUser(String userPassword, UserInfo user) {
		// TODO Auto-generated method stub
		return mapper.createUser(userPassword, user);
	}
	@Override
	public int valUserAccountIsExists(String userAccount) {
		// TODO Auto-generated method stub
		return mapper.valUserAccountIsExists(userAccount);
	}
	@Override
	public List<ChildUserInfo> getChildUserInfoByUserId(String parentUserId) {
		// TODO Auto-generated method stub
		return mapper.getChildUserInfoByUserId(parentUserId);
	}
	@Override
	public int valThisUserIsUser(String parentUserId, String userId) {
		// TODO Auto-generated method stub
		return mapper.valThisUserIsUser(parentUserId, userId);
	}
	@Override
	public int updateUserRole(String userId, String roleId) {
		// TODO Auto-generated method stub
		return mapper.updateUserRole(userId, roleId);
	}
	@Override
	public int updateUserIsDeleteByuserId(String userId) {
		// TODO Auto-generated method stub
		return mapper.updateUserIsDeleteByuserId(userId);
	}
	@Override
	public int resetPwdByuserId(String userId, String pwd) {
		// TODO Auto-generated method stub
		return mapper.resetPwdByuserId(userId, pwd);
	}
}
