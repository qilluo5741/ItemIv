package com.sharebo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sharebo.entity.Result;
import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.MenuTypeInfo;
import com.sharebo.service.UserService;
import com.sharebo.util.MD5Util;
/**
 * 用户模块
 * @author niewei
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Result login(String userName, String userPwd,
			HttpSession session) {
		userPwd=MD5Util.encode(userPwd);
		// 验证参数是否合法
		if (userName == null || userPwd == null || userPwd.length() < 6) {
			return new Result(-1, "异常来源！");
		}
		// 获取登陆信息
		UserInfo user = service.getUserInfo(userName, userPwd);
		if (user != null) {
			session.setAttribute("user", user);
			return new Result(200);// 登陆成功
		} else {
			return new Result(1001);// 失败！
		}
	}

	// 跳转主页
	@RequestMapping("/index")
	public String goIndex(ModelMap model,HttpSession session) {
		//得到用户信息
		UserInfo user =(UserInfo) session.getAttribute("user");
		if(user==null){
			return "login";//跳转登陆
		}
		List<MenuTypeInfo> mts=null;
		//判断是不是超级管理员
		if(user.getIsProperty()==1){//是
			//查询全部菜单
			mts=service.getAllMenu();
		}else{//否
			//查询相应的菜单
			mts=service.getAllMenuByRoleId(user.getRoleId());
		}
		/*for (MenuTypeInfo menuTypeInfo : mts) {
			System.out.println(menuTypeInfo.getMenuTypeName()+"---------");
			List<Menu> m=menuTypeInfo.getMenus();
			for (Menu menu : m) {
				System.out.println(menu.getMenuName());
			}
		}*/
		model.addAttribute("menuTypes", mts);
		return "menu";
	}
	//用户退出
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.removeAttribute("user");
		return "login";
	}
}
