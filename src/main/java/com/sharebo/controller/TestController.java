package com.sharebo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试
 * @author niewei
 *
 */
@Controller
public class TestController {
	/*@Autowired
	private IMQService service;*/
	@RequestMapping("sendMessage")
	public @ResponseBody String test1(){
		//service.sendMessage("sendShareboManager", "aaaaaaa");
		return "hello";
	}
	@RequestMapping("test2")
	public void test2(ModelMap mp,String userId){
		/*//ScoketCenter sc=WebScoketConfig.webSocketMap.get(userId);
		try {
			sc.sendMessage("章科你就是一个hjb");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
