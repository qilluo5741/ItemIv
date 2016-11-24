package com.sharebo.listener;

import java.util.List;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import net.sf.json.JSONObject;
import com.sharebo.config.WebScoketConfig;
import com.sharebo.webscoket.ScoketCenter;
/**
 * 消费mq消息
 * @author niewei
 *
 */
public class MQConsumerListener implements MessageListener{

	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		try {
			String res=textMsg.getText();
			//System.out.println("读取的数据"+res);
			//获取部分信息
			String commId=JSONObject.fromObject(res).getString("commId");
			String eqNo=JSONObject.fromObject(res).getString("eqNo");
			System.out.println(commId+":"+eqNo);
			//得到通信信息
			List<ScoketCenter> lists=WebScoketConfig.webSocketMap.get(commId);
			System.out.println(WebScoketConfig.webSocketMap);
			if(lists!=null){
				//遍历发送信息
				for (ScoketCenter scoketCenter : lists) {
					if(scoketCenter.getEqNo().equals(eqNo)){
						scoketCenter.sendMessage(res);
					}
				}
			}else{
				//做记录保存操作
				System.out.println("没有连接");
				//System.out.println(WebScoketConfig.webSocketMap);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
