package com.sharebo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.dto.UserDto;

public interface UserDtoService {
	/**
	 * 创建用户
	 * @param user
	 * @return
	 */
	public int addUser(UserDto user);
	/**
	 * 注销用户
	 * @param user
	 * @return
	 */
	public int updatecancellationUser(String userid);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateModifyUser(String userAccount,String userid);
	/**
	 * 根据分页查询
	 * @param map
	 * @return
	 */
	public List<UserDto> getselectUserlist(Map<String,Object> map);
	/**
	 * 根据分页查总数
	 * @return
	 */
	public int selectUserlistCount();
	/**
	 * 验证是否已经存在
	 * @param userAccount
	 * @return
	 */
	public int valserialuserAccountIsExists(String userAccount);
	/**
	 * 创建角色
	 * @param user
	 * @return
	 */
	public int addRoleInfo(String userid);
	public String seleclroleByuserId(@Param("userAccount") String userAccount);
	/**
	 * 验证旧密码是否正确
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	public String valserialuserAccountandoldpasswordIsExists(String userAccount,String userPassword);
	/**
	 * 修改密码
	 * @param userPwd
	 * @param userid
	 * @return
	 */
	public int updateModifyuserPwdUser(String userPassword,String userid);
}
