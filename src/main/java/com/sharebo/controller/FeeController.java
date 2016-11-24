package com.sharebo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharebo.config.InterfaceApiConfig;
import com.sharebo.entity.Result;
import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.EquipmentInfo;
import com.sharebo.service.FeeService;
import com.sharebo.util.HttpUtil;
/***
 * �շѹ���
 * 
 * @author niewei
 *
 */
@Controller
@RequestMapping("fee")
public class FeeController {
	private InterfaceApiConfig config;
	@Autowired
	FeeService service;

	@RequestMapping("/showFeeManager")
	public String showFeeManager(ModelMap mp, HttpSession session) {
		
		return "FeeManager";
	}
	//��ʾ���
	@RequestMapping("showIn")
	public String showIn(){
		
		return "ShowIn";
	}
	//��ʾ����
	@RequestMapping("showOut")
	public String showOut(){
		
		return "ShowOut";
	}
	//��ʾ��ѡ�豸
	@SuppressWarnings("unchecked")
	@RequestMapping("/ShowEquipment")
	public String ShowEquipment(ModelMap mp, HttpSession session,Integer isinout) {
		// �õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user == null) {
			return "login";
		}
		// ͨ���û����ҳ������ĸ�С��
		// ͨ����ǰ�û��õ�����UserId�û�
		String userId = service.getUserId(user.getUserId());
		if (userId == null) {// ��ǰUserId������ҵ
			userId = user.getUserId();
		}
		// ��ѯȫ��ͣ����
		List<com.sharebo.entity.dto.CommunityDto> comms = service
				.getAllComm(userId);
		// ƴ�Ӳ���
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < comms.size(); i++) {
			sb.append(comms.get(i).getCommVal());
			if (i < comms.size() - 1) {
				sb.append(",");
			}
		}
		//System.out.println("С������Ϣ���£�" + sb.toString());
		// ͨ��С����ѯȫ���豸 api
		String httpUrl = config.getValue("interface")
				+ "/equip/equipment.do?commId=" + sb + "&token="
				+ InterfaceApiConfig.getTokenToMd5();
		String res = HttpUtil.request_post(httpUrl, "");
		JSONArray result = JSONObject.fromObject(res).getJSONArray("result");
		List<EquipmentInfo> pager = JSONArray.toList(result,
				new EquipmentInfo(), new JsonConfig());
		List<EquipmentInfo> eqs=new ArrayList<EquipmentInfo>(); 
		for(int i=0;i<pager.size();i++){
			//System.out.println(pager.get(i).getIsinout() +pager.get(i).getEquipmentName());
			if (pager.get(i).getIsinout() == isinout) {//
				eqs.add(pager.get(i));
			}
		}
		mp.addAttribute("eqs", eqs); 
		mp.addAttribute("msg", isinout==1?"��ѡ������豸":"��ѡ������豸");
		return "ShowEquipment";
	}
	//�����볡����
	//��ѯȫ���豸
	@SuppressWarnings("unchecked")
	@RequestMapping("/ShowEquipment_result")
	public @ResponseBody Map<String,Object> ShowEquipment_result(HttpSession session) {
		// �õ��û�
		UserInfo user = (UserInfo) session.getAttribute("user");
		// ͨ���û����ҳ������ĸ�С��
		// ͨ����ǰ�û��õ�����UserId�û�
		String userId = service.getUserId(user.getUserId());
		if (userId == null) {// ��ǰUserId������ҵ
			userId = user.getUserId();
		}
		// ��ѯȫ��ͣ����
		List<com.sharebo.entity.dto.CommunityDto> comms = service
				.getAllComm(userId);
		// ƴ�Ӳ���
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < comms.size(); i++) {
			sb.append(comms.get(i).getCommVal());
			if (i < comms.size() - 1) {
				sb.append(",");
			}
		}
		//System.out.println("С������Ϣ���£�" + sb.toString());
		// ͨ��С����ѯȫ���豸 api
		String httpUrl = config.getValue("interface")
				+ "/equip/equipment.do?commId=" + sb + "&token="
				+ InterfaceApiConfig.getTokenToMd5();
		String res = HttpUtil.request_post(httpUrl, "");
		JSONArray result = JSONObject.fromObject(res).getJSONArray("result");
		List<EquipmentInfo> pager = JSONArray.toList(result,
				new EquipmentInfo(), new JsonConfig());
		List<EquipmentInfo> eqsIn=new ArrayList<EquipmentInfo>();
		List<EquipmentInfo> eqsOut=new ArrayList<EquipmentInfo>(); 
		for(int i=0;i<pager.size();i++){
			//System.out.println(pager.get(i).getIsinout() +pager.get(i).getEquipmentName());
			if (pager.get(i).getIsinout() == 1) {//��
				eqsIn.add(pager.get(i));
			}else{
				eqsOut.add(pager.get(i));
			}
		}
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("eqsIn", eqsIn);
		map.put("eqsOut", eqsOut);
		return map;
	}
	

	/**
	 * �޸��շ�ģʽ
	 * @param commId
	 * @param money
	 * @param feeModel
	 * @param maxMoney
	 * @return
	 */
	@RequestMapping("updateFeeTypeByCommId")
	@ResponseBody
	public Result updateFeeType(String commId,Double money,Integer feeModel,Double maxMoney,Integer freeMin){
		if(commId==null||money==null||feeModel==null||maxMoney==null){
			return new Result(3002,"��������д��������Ϣ");
		}
		String httpUrl=config.getValue("interface")+"/fee/updateFeeType.do?commId="+commId+"&money="+money+"&feeModel="+feeModel+"&maxMoney="+maxMoney+"&freeMin="+freeMin+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"�޸ĳɹ�");
		}
		return new Result(3003,"�޸�ʧ��");
	}
	/**
	 * ��ѯ�շ�ģʽ
	 * @param commId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getFeeTypeByCommId")
	public Result getFeeTypeByCommId(String commId){
		if(commId==null){
			return new Result(3001,"�����������Ϊ��");
		}
		String httpUrl=config.getValue("interface")+"/fee/getFeeType.do?commId="+commId+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String result=JSONObject.fromObject(res).getString("result");
		JSONObject resu=JSONObject.fromObject(result);
		System.out.println(resu);
		if(resu!=null){
			return new Result(200,"��ѯ�ɹ�",resu);
		}        
		return new Result(3002,"��ѯʧ��");
	}
	/**
	 * �޸ĳ�����ʷ���ƺ�
	 * @param vehicleId
	 * @param carNo
	 * @return
	 */
	@RequestMapping("updateCarNo")
	@ResponseBody
	public Result updateCarNo(String vehicleId,String carNo){
		if(vehicleId==null||carNo==null){
			return new Result(3001,"�����������Ϊ��");
		}
		String httpUrl="";
		try {
			httpUrl = config.getValue("interface")+"/fee/updateCarNo.do?vehicleId="+vehicleId+"&carNo="+URLEncoder.encode(carNo,"UTF-8")+"&token="+config.getTokenToMd5();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String res=HttpUtil.request_post(httpUrl, "");
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"��ϲ��,�ɹ��޸��˳��ƺ�O(��_��)O~~");
		}
		return new Result(3002,"���ź�,�޸ĳ��ƺ�ʧ����o(�s���t)o");
	}
	/**
	 * ȷ���շ�
	 * @param vehicleId
	 * @param carType
	 * @param paidInFee
	 * @return
	 */
	@RequestMapping("valCharge")
	@ResponseBody
	public Result valCharge(String vehicleId,Integer carType,Double paidInFee){
		if(vehicleId==null||carType==null||paidInFee==null){
			return new Result(3001,"�����������Ϊ��");
		}
		String httpUrl=config.getValue("interface")+"/fee/confirmCharge.do?vehicleId="+vehicleId+"&carType="+carType+"&paidInFee="+paidInFee+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"�շѳɹ�");
		}
		return new Result(3002,"�շ�ʧ��");
	}
}
