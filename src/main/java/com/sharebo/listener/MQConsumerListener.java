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
 * ����mq��Ϣ
 * @author niewei
 *
 */
public class MQConsumerListener implements MessageListener{

	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		try {
			String res=textMsg.getText();
			//System.out.println("��ȡ������"+res);
			//��ȡ������Ϣ
			String commId=JSONObject.fromObject(res).getString("commId");
			String eqNo=JSONObject.fromObject(res).getString("eqNo");
			System.out.println(commId+":"+eqNo);
			//�õ�ͨ����Ϣ
			List<ScoketCenter> lists=WebScoketConfig.webSocketMap.get(commId);
			System.out.println(WebScoketConfig.webSocketMap);
			if(lists!=null){
				//����������Ϣ
				for (ScoketCenter scoketCenter : lists) {
					if(scoketCenter.getEqNo().equals(eqNo)){
						scoketCenter.sendMessage(res);
					}
				}
			}else{
				//����¼�������
				System.out.println("û������");
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
