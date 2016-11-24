package com.sharebo.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.sharebo.service.IMQService;
import com.sharebo.util.SpringContextUtil;


@Service
public class IMQServiceImpl implements IMQService{
	@Autowired
	private JmsTemplate jmsTemplate;
	//�����ı���Ϣ
	public void sendMessage(String queueStr, final String message){
		//�õ�bean
		//�õ�����������֪ͨĿ������
		Destination destination = (Destination) SpringContextUtil.getBean(queueStr);
		System.out.println("���ͣ�" + message);
		jmsTemplate.send(destination, new MessageCreator() {
					public Message createMessage(Session session) throws JMSException {
						return session.createTextMessage(message);
					}
				});
	}
	public void sendObject(String queueStr, Object object) {
		
	}
}
