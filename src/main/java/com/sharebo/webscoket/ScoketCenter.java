package com.sharebo.webscoket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sharebo.config.WebScoketConfig;

@ServerEndpoint("/scoket_server")
public class ScoketCenter {
	// ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
	private  Session session;
	//�豸��
	private String eqNo;
	//С��Id
	/**
	 * ���ӽ����ɹ����õķ���
	 * @param session
	 * ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
	 */
	@OnOpen
	public void onOpen(Session session) {
		
		this.session = session;
		String eqNo=session.getRequestParameterMap().get("eqNo").get(0);
		this.eqNo=eqNo;
		String commId=session.getRequestParameterMap().get("commId").get(0);
		//��֤�豸�Ƿ��Ѿ�����
		/*if(WebScoketConfig.webSocketMap.get(eqNo)!=null){
			return;
		}*/
		System.out.println("��ǰ���ӵ��豸�ţ�"+eqNo+"ͣ����Id:"+commId);
		
		List<ScoketCenter> list=WebScoketConfig.webSocketMap.get(commId);
		if(list==null){
			list=new ArrayList<ScoketCenter>();
		}
		list.add(this);
		WebScoketConfig.webSocketMap.put(commId, list);
		System.out.println("�������Ӽ��룡��ǰ������Ϊ" + WebScoketConfig.webSocketMap.size());
	}
	  /**
     * ���ӹرյ��õķ���
     */
    @OnClose
    public void onClose(){
    	//ɾ������
    	WebScoketConfig.webSocketMap.remove(session.getRequestParameterMap().get("commId").get(0));
    	System.out.println("�������Ӽ��룡��ǰ������Ϊ" + WebScoketConfig.webSocketMap.size());
    }
    
    /**
     * �յ��ͻ�����Ϣ����õķ���
     * @param message �ͻ��˷��͹�������Ϣ
     * @param session ��ѡ�Ĳ���
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("���Կͻ��˵���Ϣ:" + message);
    }
    
    /**
     * ��������ʱ����
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("��������");
        error.printStackTrace();
    }
    
    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        //this.session.getBasicRemote().sendText(message);
        this.session.getBasicRemote().sendText(message, true);
        //this.session.getAsyncRemote().sendText(message);
    }
	public String getEqNo() {
		return eqNo;
	}
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
    
}
