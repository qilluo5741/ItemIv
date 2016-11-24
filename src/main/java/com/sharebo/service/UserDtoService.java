package com.sharebo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.dto.UserDto;

public interface UserDtoService {
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
	public int updatecancellationUser(String userid);
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	public int updateModifyUser(String userAccount,String userid);
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
	public int valserialuserAccountIsExists(String userAccount);
	/**
	 * ������ɫ
	 * @param user
	 * @return
	 */
	public int addRoleInfo(String userid);
	public String seleclroleByuserId(@Param("userAccount") String userAccount);
	/**
	 * ��֤�������Ƿ���ȷ
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	public String valserialuserAccountandoldpasswordIsExists(String userAccount,String userPassword);
	/**
	 * �޸�����
	 * @param userPwd
	 * @param userid
	 * @return
	 */
	public int updateModifyuserPwdUser(String userPassword,String userid);
}
