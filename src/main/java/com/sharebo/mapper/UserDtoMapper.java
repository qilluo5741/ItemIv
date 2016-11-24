package com.sharebo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.dto.UserDto;

public interface UserDtoMapper {
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
	public int updatecancellationUser(@Param("userid") String userid);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateModifyUser(@Param("userAccount")String userAccount,@Param("userid") String userid);
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
	public int valserialuserAccountIsExists(@Param("userAccount") String userAccount);
	/**
	 * 创建角色
	 * @param user
	 * @return
	 */
	public int addRoleInfo(@Param("userid") String userid);
	/**
	 * 
	 * @param userAccount
	 * @return
	 */
	public String seleclroleByuserId(@Param("userAccount") String userAccount);
	/**
	 * 验证旧密码是否正确
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	public String valserialuserAccountandoldpasswordIsExists(@Param("userAccount") String userAccount,@Param("userPassword") String userPassword);
	/**
	 * 修改密码
	 * @param userPwd
	 * @param userid
	 * @return
	 */
	public int updateModifyuserPwdUser(@Param("userPassword")String userPassword,@Param("userid") String userid);
}
