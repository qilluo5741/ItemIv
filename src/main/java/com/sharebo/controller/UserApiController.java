package com.sharebo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sharebo.entity.Pager;
import com.sharebo.entity.Result;
import com.sharebo.entity.dto.UserDto;
import com.sharebo.service.UserDtoService;
import com.sharebo.util.MD5Util;
/**
 * ���ߣ�weimeilayer@163.com
 * ʱ�䣺2016-10-14
 * @author Administrator
 */
@Controller
@RequestMapping("user")
public class UserApiController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDtoService service;
	/**
	 * �����û�
	 * user/addUser.do?userAccount=&userPassword=
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="addUser")
	public Result addUserinfo(UserDto user){
		if(user.getUserAccount()==null && user.getUserPassword()==null){
			return new Result(2003,"�������Ϊ�գ�");
		}
		if(service.valserialuserAccountIsExists(user.getUserAccount())>0){
			return new Result(2004,"���û��Ѿ����ڣ�");
		}
		String passwords = MD5Util.encode(user.getUserPassword());
		String password = MD5Util.encode(passwords);
		user.setUserPassword(password);
		user.setUserId(UUID.randomUUID().toString().replace("-",""));
		try {
			if(service.addUser(user)>0){
				if(service.addRoleInfo(service.seleclroleByuserId(user.getUserAccount()))>0){
					return new Result(200,"�����ɹ�");
				}
			}
		} catch (Exception e) {
			log.error("�����쳣");
		}
		return new Result(2003,"����ʧ��");
	}
	/**
	 * ע���û�
	 * user/updatecancellationUser.do?userid=11842149236604928029
	 * @param userid
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="updatecancellationUser")
	public Result updatecancellationUser(String userid){
		if(userid==null){
			return new Result(2003,"�������Ϊ�գ�");
		}
		try {
			if(service.updatecancellationUser(userid)>0){
				return new Result(200,"ע���ɹ�");
			}
		} catch (Exception e) {
			log.error("ע���쳣");
		}
		return new Result(2003,"ע��ʧ��");
	}
	/**
	 * �޸��û��˻�
	 * user/updateModifyUser.do?userAccount=4542&userid=11842149236604928029
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="updateModifyUser")
	public Result updateModifyUser(String userAccount,String userid){
		if(userAccount==null && userid==null){
			return new Result(2003,"�������Ϊ�գ�");
		}
		try {
			if(service.updateModifyUser(userAccount,userid)>0){
				return new Result(200,"�޸ĳɹ�");
			}
		} catch (Exception e) {
			log.error("�޸��쳣");
			e.getStackTrace();
		}
		return new Result(2003,"�޸�ʧ��");
	}
	/**
	 *	��ҳ��ѯ�û�
	 * user/getuserlist.do?pageIndex=1&pageSize=10
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
    @RequestMapping("getuserlist")
	 public Result getuserlist(Integer pageIndex,Integer pageSize){
    	try {
    		if(pageIndex==null || pageSize==null || pageIndex==0){
				return new Result(3006,"����������Ϸ�");
			}
    		Pager<UserDto> pager=new Pager<UserDto>();
			pager.setPageIndex(pageIndex);
			pager.setPageSize(pageSize);
			Map<String, Object> map=new HashMap<String, Object>();
			//���ÿ�ʼ
			int pageBegin=(pageIndex-1)*pageSize;
			map.put("pageBegin", pageBegin);
			map.put("pageSize", pageSize);
			pager.setList(service.getselectUserlist(map));
			//��ѯ����
			pager.setTotalNumber(service.selectUserlistCount());
			pager.setTotalPages();//������ҳ��
			return new Result(200,"��ѯ�ɹ�",pager);
		} catch (Exception e) {
			log.error("��ҳ��ѯ�û������쳣��");
			System.out.println("��ҳ��ѯ�û������쳣��");
		}
    	return new Result(3002,"��������");
	}
	/**
	 * �û��Լ��޸�����
	 * user/updatemodify.do
	 * @param userName
	 * @param oldpassword
	 * @param newpassword
	 * @return
	 */
	@ResponseBody
    @RequestMapping("updatemodify")
	public Result updatemodifyUser(String userName,String oldpassword,String newpassword){
		try {
			String userPwd=MD5Util.encode(oldpassword);
			String newpword=MD5Util.encode(newpassword);
			String userid=service.valserialuserAccountandoldpasswordIsExists(userName,userPwd);
			if(userid!=null){
				if(service.updateModifyuserPwdUser(newpword,userid)>=0){
					return new Result(200,"�ɹ�");
				}
			}else{
				return new Result(2001,"ԭ�����������");
			}
		} catch (Exception e) {
			log.error("�޸������쳣��");
			System.out.println("�޸������쳣��");
		}
    	return new Result(300,"�޸�����ʧ��");
	}
}
