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
 * �û�ģ��
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
		// ��֤�����Ƿ�Ϸ�
		if (userName == null || userPwd == null || userPwd.length() < 6) {
			return new Result(-1, "�쳣��Դ��");
		}
		// ��ȡ��½��Ϣ
		UserInfo user = service.getUserInfo(userName, userPwd);
		if (user != null) {
			session.setAttribute("user", user);
			return new Result(200);// ��½�ɹ�
		} else {
			return new Result(1001);// ʧ�ܣ�
		}
	}

	// ��ת��ҳ
	@RequestMapping("/index")
	public String goIndex(ModelMap model,HttpSession session) {
		//�õ��û���Ϣ
		UserInfo user =(UserInfo) session.getAttribute("user");
		if(user==null){
			return "login";//��ת��½
		}
		List<MenuTypeInfo> mts=null;
		//�ж��ǲ��ǳ�������Ա
		if(user.getIsProperty()==1){//��
			//��ѯȫ���˵�
			mts=service.getAllMenu();
		}else{//��
			//��ѯ��Ӧ�Ĳ˵�
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
	//�û��˳�
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.removeAttribute("user");
		return "login";
	}
}
