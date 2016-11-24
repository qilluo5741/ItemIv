package com.sharebo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.dto.UserDto;

public interface UserDtoMapper {
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public int addUser(UserDto user);
	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	public int updatecancellationUser(@Param("userid") String userid);
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	public int updateModifyUser(@Param("userAccount")String userAccount,@Param("userid") String userid);
	/**
	 * ���ݷ�ҳ��ѯ
	 * @param map
	 * @return
	 */
	public List<UserDto> getselectUserlist(Map<String,Object> map);
	/**
	 * ���ݷ�ҳ������
	 * @return
	 */
	public int selectUserlistCount();
	/**
	 * ��֤�Ƿ��Ѿ�����
	 * @param userAccount
	 * @return
	 */
	public int valserialuserAccountIsExists(@Param("userAccount") String userAccount);
	/**
	 * ������ɫ
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
	 * ��֤�������Ƿ���ȷ
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	public String valserialuserAccountandoldpasswordIsExists(@Param("userAccount") String userAccount,@Param("userPassword") String userPassword);
	/**
	 * �޸�����
	 * @param userPwd
	 * @param userid
	 * @return
	 */
	public int updateModifyuserPwdUser(@Param("userPassword")String userPassword,@Param("userid") String userid);
}
