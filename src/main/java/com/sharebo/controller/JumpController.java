package com.sharebo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
	// ��ת��½
	@RequestMapping("user/goLogin")
	public String goLogin(){
		return "login";
	}
	//������־��¼
	// 404
	@RequestMapping("404")
	public String _404() {
		return "404";
	}

	// 500
	@RequestMapping("500")
	public String _500() {
		return "500";
	}
}
