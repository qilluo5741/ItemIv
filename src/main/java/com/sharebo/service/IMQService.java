package com.sharebo.service;

public interface IMQService {
	//�����ı���Ϣ
	public void sendMessage(String queueStr, final String message);
	//����Object
	public void sendObject(String queueStr,final Object object);
	//����map
	//����Object
	//����byte
}
