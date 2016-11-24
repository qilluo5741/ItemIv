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
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private  Session session;
	//设备号
	private String eqNo;
	//小区Id
	/**
	 * 连接建立成功调用的方法
	 * @param session
	 * 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(Session session) {
		
		this.session = session;
		String eqNo=session.getRequestParameterMap().get("eqNo").get(0);
		this.eqNo=eqNo;
		String commId=session.getRequestParameterMap().get("commId").get(0);
		//验证设备是否已经链接
		/*if(WebScoketConfig.webSocketMap.get(eqNo)!=null){
			return;
		}*/
		System.out.println("当前链接的设备号："+eqNo+"停车场Id:"+commId);
		
		List<ScoketCenter> list=WebScoketConfig.webSocketMap.get(commId);
		if(list==null){
			list=new ArrayList<ScoketCenter>();
		}
		list.add(this);
		WebScoketConfig.webSocketMap.put(commId, list);
		System.out.println("有新连接加入！当前在线数为" + WebScoketConfig.webSocketMap.size());
	}
	  /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
    	//删除链接
    	WebScoketConfig.webSocketMap.remove(session.getRequestParameterMap().get("commId").get(0));
    	System.out.println("有新连接加入！当前在线数为" + WebScoketConfig.webSocketMap.size());
    }
    
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
    }
    
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }
    
    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
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
