package com.yc.ycSpringBoot.biz;

import java.io.IOException;
import java.util.Hashtable;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/websocket/{id}")
@Component
public class MyWebSocket {
	//
	private static Hashtable<String, Session> webSocketMap=new Hashtable<>();
	
	@OnOpen
	public void onOpen(@PathParam("id")String id, Session session) {
		System.out.println(id+"已经连接成功！");
		webSocketMap.put(id, session);
		
	}
	
	@OnClose
	public void onClose(Session session) {
		//移除webSocketMap中的会话
	}
	
	@OnMessage
	public void onMessage(String message, Session session )throws Exception{
		//String msg ="a:你好";
		String[]ss	= message.split(":");
		String id=ss[0];
		String msg=ss[1];
		Session targetSession = webSocketMap.get(id);
		if (targetSession !=null) {
			targetSession.getBasicRemote().sendText(msg);
		}else {
			System.out.println(id+"不在线！");
		}
	}
	
	//每2分钟执行一次
	@Scheduled(cron = "0 */2 * * * ?")
	public void luckYou() throws IOException {
		for(Session session : webSocketMap.values()) {
			session.getBasicRemote().sendText("祝你好运！");
		}
	}
}
