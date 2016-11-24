package com.sharebo.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sharebo.webscoket.ScoketCenter;


public class WebScoketConfig {
	// 实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为小区标识
	public static final Map<String, List<ScoketCenter>> webSocketMap = new HashMap<String, List<ScoketCenter>>();
}
