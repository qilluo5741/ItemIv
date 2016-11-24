package com.sharebo.config;

import java.util.Map;

import com.sharebo.util.MD5Util;

/**
 * �ӿڿ��ַ
 * @author niewei
 *
 */
public class InterfaceApiConfig {
	private static InterfaceApiConfig apiConfig;
	 InterfaceApiConfig() {
		apiConfig=this;
	}
	private static Map<String, String> mapconfig;
	private static String token;
	
	//��ȡһ��ֵ
	@SuppressWarnings("static-access")
	public static String getValue(String key){
		return apiConfig.getMapconfig().get(key);
	}
	//��ȡtoken
	@SuppressWarnings("static-access")
	public static String getTokenToMd5() {
		return MD5Util.encode(apiConfig.getToken());
	}
	public static Map<String, String> getMapconfig() {
		return mapconfig;
	}
	public static void setMapconfig(Map<String, String> mapconfig) {
		InterfaceApiConfig.mapconfig = mapconfig;
	}
	public static String getToken() {
		return token;
	}
	public static void setToken(String token) {
		InterfaceApiConfig.token = token;
	}
}
