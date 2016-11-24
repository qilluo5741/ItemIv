package com.sharebo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharebo.config.InterfaceApiConfig;
import com.sharebo.entity.Result;
import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.EquipmentInfo;
import com.sharebo.service.EquipmentService;
import com.sharebo.service.FeeService;
import com.sharebo.util.HttpUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * �豸����
 * @author Administrator
 *
 */
@Controller
@RequestMapping("equipment")
public class EquipmentController {
	@Autowired
	private EquipmentService service;
	@Autowired
	private FeeService Fservice;
	private InterfaceApiConfig config;
	/**
	 * ��ѯ�豸��Ϣ
	 * HttpSession session
	 * @param session
	 * @return
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	@RequestMapping("getCommVal")
	public String test(HttpSession session,ModelMap mp){
		UserInfo user=(UserInfo) session.getAttribute("user");
		if (user == null) {
			return "login";
		}
		String userId=Fservice.getUserId(user.getUserId());
		if(userId==null){//���˺Ų�����ҵ
			userId=user.getUserId();;
		}
		List<String> list=service.selectCommValByUserId(userId);
		if(list!=null){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i));
			if(i<list.size()-1){
				sb.append(",");
			}
		}
		String httpUrl=config.getValue("interface")+"/equip/equipment.do?commId="+sb+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		JSONArray result=JSONObject.fromObject(res).getJSONArray("result");
		System.out.println(result);
		List<EquipmentInfo> pager=JSONArray.toList(result, new EquipmentInfo(), new JsonConfig());
		System.out.println(pager);
		mp.addAttribute("pager", pager);
		}
		return "equipmentManager";
		}
	
	/**
	 * �޸��豸����
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("updateEquipmentName")
	@ResponseBody
	public Result updateEquipmentName(String equipmentNumber,String equipmentName){
		try {
			String httpUrl = config.getValue("interface")+"/equip/updatequiName.do?equipmentNumber="+equipmentNumber+"&equipmentName="+URLEncoder.encode(equipmentName,"UTF-8")+"&token="+config.getTokenToMd5();
			String res=HttpUtil.request_post(httpUrl, "");
			System.out.println(res);
			String code=JSONObject.fromObject(res).getString("code");
			System.out.println(code);
			if(code.equals("200")){
				return new Result(200,"�޸ĳɹ�");
			}
			return new Result(3001,"�޸��豸����ʧ��");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new Result(3002,"�޸��豸�����쳣");
	}
	/**
	 * ȡ��/�����շ�ͤ
	 * @param equipmentNumber
	 * @param isTollBooths
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateIsTollBooths")
	public Result updateIsTollBooths(String equipmentNumber,Integer isTollBooths){
		if(equipmentNumber==null){
			return new Result(3001,"�����������Ϊ��");
		}
		String httpUrl=config.getValue("interface")+"/equip/updateIsTollBooths.do?equipmentNumber="+equipmentNumber+"&isTollBooths="+isTollBooths+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"���óɹ�");
		}
		return new Result(3003,"����ʧ��");
	}

}
