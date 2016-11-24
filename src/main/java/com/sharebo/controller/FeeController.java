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
 * 收费管理
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
	//显示入口
	@RequestMapping("showIn")
	public String showIn(){
		
		return "ShowIn";
	}
	//显示出口
	@RequestMapping("showOut")
	public String showOut(){
		
		return "ShowOut";
	}
	//显示可选设备
	@SuppressWarnings("unchecked")
	@RequestMapping("/ShowEquipment")
	public String ShowEquipment(ModelMap mp, HttpSession session,Integer isinout) {
		// 得到用户
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user == null) {
			return "login";
		}
		// 通过用户查找出属于哪个小区
		// 通过当前用户得到最终UserId用户
		String userId = service.getUserId(user.getUserId());
		if (userId == null) {// 当前UserId就是物业
			userId = user.getUserId();
		}
		// 查询全部停车场
		List<com.sharebo.entity.dto.CommunityDto> comms = service
				.getAllComm(userId);
		// 拼接参数
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < comms.size(); i++) {
			sb.append(comms.get(i).getCommVal());
			if (i < comms.size() - 1) {
				sb.append(",");
			}
		}
		//System.out.println("小区的信息如下：" + sb.toString());
		// 通过小区查询全部设备 api
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
		mp.addAttribute("msg", isinout==1?"请选择入口设备":"请选择出口设备");
		return "ShowEquipment";
	}
	//进入入场监视
	//查询全部设备
	@SuppressWarnings("unchecked")
	@RequestMapping("/ShowEquipment_result")
	public @ResponseBody Map<String,Object> ShowEquipment_result(HttpSession session) {
		// 得到用户
		UserInfo user = (UserInfo) session.getAttribute("user");
		// 通过用户查找出属于哪个小区
		// 通过当前用户得到最终UserId用户
		String userId = service.getUserId(user.getUserId());
		if (userId == null) {// 当前UserId就是物业
			userId = user.getUserId();
		}
		// 查询全部停车场
		List<com.sharebo.entity.dto.CommunityDto> comms = service
				.getAllComm(userId);
		// 拼接参数
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < comms.size(); i++) {
			sb.append(comms.get(i).getCommVal());
			if (i < comms.size() - 1) {
				sb.append(",");
			}
		}
		//System.out.println("小区的信息如下：" + sb.toString());
		// 通过小区查询全部设备 api
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
			if (pager.get(i).getIsinout() == 1) {//入
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
	 * 修改收费模式
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
			return new Result(3002,"请认真填写完所有信息");
		}
		String httpUrl=config.getValue("interface")+"/fee/updateFeeType.do?commId="+commId+"&money="+money+"&feeModel="+feeModel+"&maxMoney="+maxMoney+"&freeMin="+freeMin+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"修改成功");
		}
		return new Result(3003,"修改失败");
	}
	/**
	 * 查询收费模式
	 * @param commId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getFeeTypeByCommId")
	public Result getFeeTypeByCommId(String commId){
		if(commId==null){
			return new Result(3001,"请求参数不能为空");
		}
		String httpUrl=config.getValue("interface")+"/fee/getFeeType.do?commId="+commId+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String result=JSONObject.fromObject(res).getString("result");
		JSONObject resu=JSONObject.fromObject(result);
		System.out.println(resu);
		if(resu!=null){
			return new Result(200,"查询成功",resu);
		}        
		return new Result(3002,"查询失败");
	}
	/**
	 * 修改车辆历史车牌号
	 * @param vehicleId
	 * @param carNo
	 * @return
	 */
	@RequestMapping("updateCarNo")
	@ResponseBody
	public Result updateCarNo(String vehicleId,String carNo){
		if(vehicleId==null||carNo==null){
			return new Result(3001,"请求参数不能为空");
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
			return new Result(200,"恭喜您,成功修改了车牌号O(∩_∩)O~~");
		}
		return new Result(3002,"很遗憾,修改车牌号失败了o(╯□╰)o");
	}
	/**
	 * 确认收费
	 * @param vehicleId
	 * @param carType
	 * @param paidInFee
	 * @return
	 */
	@RequestMapping("valCharge")
	@ResponseBody
	public Result valCharge(String vehicleId,Integer carType,Double paidInFee){
		if(vehicleId==null||carType==null||paidInFee==null){
			return new Result(3001,"请求参数不能为空");
		}
		String httpUrl=config.getValue("interface")+"/fee/confirmCharge.do?vehicleId="+vehicleId+"&carType="+carType+"&paidInFee="+paidInFee+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"收费成功");
		}
		return new Result(3002,"收费失败");
	}
}
