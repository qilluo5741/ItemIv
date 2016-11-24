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
 * 作者：weimeilayer@163.com
 * 时间：2016-10-14
 * @author Administrator
 */
@Controller
@RequestMapping("user")
public class UserApiController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDtoService service;
	/**
	 * 创建用户
	 * user/addUser.do?userAccount=&userPassword=
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="addUser")
	public Result addUserinfo(UserDto user){
		if(user.getUserAccount()==null && user.getUserPassword()==null){
			return new Result(2003,"请求参数为空！");
		}
		if(service.valserialuserAccountIsExists(user.getUserAccount())>0){
			return new Result(2004,"该用户已经存在！");
		}
		String passwords = MD5Util.encode(user.getUserPassword());
		String password = MD5Util.encode(passwords);
		user.setUserPassword(password);
		user.setUserId(UUID.randomUUID().toString().replace("-",""));
		try {
			if(service.addUser(user)>0){
				if(service.addRoleInfo(service.seleclroleByuserId(user.getUserAccount()))>0){
					return new Result(200,"创建成功");
				}
			}
		} catch (Exception e) {
			log.error("创建异常");
		}
		return new Result(2003,"创建失败");
	}
	/**
	 * 注销用户
	 * user/updatecancellationUser.do?userid=11842149236604928029
	 * @param userid
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="updatecancellationUser")
	public Result updatecancellationUser(String userid){
		if(userid==null){
			return new Result(2003,"请求参数为空！");
		}
		try {
			if(service.updatecancellationUser(userid)>0){
				return new Result(200,"注销成功");
			}
		} catch (Exception e) {
			log.error("注销异常");
		}
		return new Result(2003,"注销失败");
	}
	/**
	 * 修改用户账户
	 * user/updateModifyUser.do?userAccount=4542&userid=11842149236604928029
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="updateModifyUser")
	public Result updateModifyUser(String userAccount,String userid){
		if(userAccount==null && userid==null){
			return new Result(2003,"请求参数为空！");
		}
		try {
			if(service.updateModifyUser(userAccount,userid)>0){
				return new Result(200,"修改成功");
			}
		} catch (Exception e) {
			log.error("修改异常");
			e.getStackTrace();
		}
		return new Result(2003,"修改失败");
	}
	/**
	 *	分页查询用户
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
				return new Result(3006,"请求参数不合法");
			}
    		Pager<UserDto> pager=new Pager<UserDto>();
			pager.setPageIndex(pageIndex);
			pager.setPageSize(pageSize);
			Map<String, Object> map=new HashMap<String, Object>();
			//设置开始
			int pageBegin=(pageIndex-1)*pageSize;
			map.put("pageBegin", pageBegin);
			map.put("pageSize", pageSize);
			pager.setList(service.getselectUserlist(map));
			//查询总数
			pager.setTotalNumber(service.selectUserlistCount());
			pager.setTotalPages();//设置总页数
			return new Result(200,"查询成功",pager);
		} catch (Exception e) {
			log.error("分页查询用户参数异常！");
			System.out.println("分页查询用户参数异常！");
		}
    	return new Result(3002,"暂无数据");
	}
	/**
	 * 用户自己修改密码
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
					return new Result(200,"成功");
				}
			}else{
				return new Result(2001,"原密码密码错误！");
			}
		} catch (Exception e) {
			log.error("修改密码异常！");
			System.out.println("修改密码异常！");
		}
    	return new Result(300,"修改密码失败");
	}
}
