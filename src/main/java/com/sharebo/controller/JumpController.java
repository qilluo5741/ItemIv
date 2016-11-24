package com.sharebo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
	// 跳转登陆
	@RequestMapping("user/goLogin")
	public String goLogin(){
		return "login";
	}
	//用于日志记录
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
