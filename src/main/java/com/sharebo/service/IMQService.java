package com.sharebo.service;

public interface IMQService {
	//发送文本消息
	public void sendMessage(String queueStr, final String message);
	//发送Object
	public void sendObject(String queueStr,final Object object);
	//发送map
	//发送Object
	//发送byte
}
