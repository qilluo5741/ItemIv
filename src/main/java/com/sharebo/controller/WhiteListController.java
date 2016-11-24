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
import com.sharebo.entity.Pager;
import com.sharebo.entity.Pagers;
import com.sharebo.entity.Result;
import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.CommunityDto;
import com.sharebo.entity.dto.WhiteListDto;
import com.sharebo.service.FeeService;
import com.sharebo.service.WhiteListService;
import com.sharebo.util.HttpUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("whiteList")
public class WhiteListController {
	@Autowired
	private WhiteListService service;
	@Autowired
	private FeeService Fservice;
	
	private InterfaceApiConfig config;
	/**
	 * ��ѯ��ҵ��������С��
	 * @param userId
	 * @param mp
	 * @return
	 */
	@RequestMapping("selectCommName")
	public String selectCommNameByUserId(HttpSession session,ModelMap mp){
		UserInfo user=(UserInfo) session.getAttribute("user");
		if (user == null) {
			return "login";
		}
		String userId=Fservice.getUserId(user.getUserId());
		if(userId==null){//���˺Ų�����ҵ
			userId=user.getUserId();;
		}
		System.out.println(userId);
		List<CommunityDto> pager=service.getCommIdByUserId(userId);
		mp.addAttribute("pager", pager);
		return "AllWhiteList";
		
	}
	/**
	 * ��������ѯ
	 * @param commId
	 * @param carNo
	 * @param name
	 * @param address
	 * @return
	 */
	@RequestMapping("getWhiteList")
	public String getWhiteList(String commId,String carNo,String name,String address,ModelMap mp,Integer pageIndex,Integer pageSize){
		Pagers<WhiteListDto> pager=new Pagers<WhiteListDto>();
		pager.setPageIndex(pageIndex==null?1:pageIndex);
		pager.setPageSize(6);
		StringBuffer sb=new StringBuffer();
		String url=config.getValue("interface")+"/white/getwhitelist.do?commId="+commId+"&pageIndex="+pager.getPageIndex()+"&pageSize="+pager.getPageSize()+"&token="+config.getTokenToMd5();
		sb.append(url);
		if(carNo!=null){
			try { 
				sb.append("+&carNo="+URLEncoder.encode(carNo,"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if(name!=null){
			try {
				sb.append("+&name="+URLEncoder.encode(name,"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if(address!=null){
			try {
				sb.append("+&address="+URLEncoder.encode(address,"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String res=HttpUtil.request_post(sb.toString().replace("+", ""), "");
		System.out.println(sb.toString().replace("+", ""));
		System.out.println(res);
		String result=JSONObject.fromObject(res).getString("result");
		System.out.println("������Ϊ:"+JSONObject.fromObject(result).getInt("totalRecords"));
		JSONArray list=JSONObject.fromObject(result).getJSONArray("list");
		List<WhiteListDto> wList=JSONArray.toList(list, new WhiteListDto(), new JsonConfig());
		pager.setList(wList);
		//��ѯ����
		pager.setTotalRecords(JSONObject.fromObject(result).getInt("totalRecords"));
		pager.setTotalPages();//������ҳ��
		mp.addAttribute("pager",pager);
		return "WhiteList";
	}
	/**
	 * ��Ӱ�����
	 * @param commId
	 * @param name
	 * @param carNo
	 * @param address
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping("newWhiteList")
	public Result CreateNewWhiteList(String commId,String name,String carNo,String address,String phone,String periodvalidity,String chargeTimeType){
		if(carNo==null){
			return new Result(3001,"����û����ӳ��ƺ�");
		}
		String httpUrl="";
		try {
			httpUrl = config.getValue("interface")+"/white/whitelist.do?commId="+commId+"&address="+URLEncoder.encode(address,"UTF-8")+"&name="+URLEncoder.encode(name,"UTF-8")+"&carNo="+URLEncoder.encode(carNo,"UTF-8")+"&phone="+phone+"&periodvalidity="+periodvalidity+"&chargeTimeType="+chargeTimeType+"&token="+config.getTokenToMd5();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(httpUrl);
		String res=HttpUtil.request_post(httpUrl, "");
		System.out.println(res);
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"�ɹ���Ӱ�����");
		}
		return new Result(3002,"��Ӱ�����ʧ��");
	}
	/**
	 * ɾ��������
	 * @param whitelistId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteWhiteList")
	public Result deleteWhiteList(String whitelistId){
		if(whitelistId==null){
			return new Result(3003,"�����������Ϊ��");
		}
		String httpUrl=config.getValue("interface")+"/white/delectwhitelist.do?whitelistId="+whitelistId+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"�ɹ�ɾ��������");
		}
		return new Result(3004,"ɾ��������ʧ��");
	}
	/**
	 * �޸İ�������Ч��
	 * @param whitelistId
	 * @param isfailure
	 * @param periodvalidity
	 * @param chargeTimeType
	 * @return
	 */
    @RequestMapping("updateisfailure")
    @ResponseBody
    public Result updateisfailure(String whitelistId,Integer isfailure,String periodvalidity,Integer chargeTimeType){
    	if(whitelistId==null){
    		return new Result(3001,"�����������Ϊ��!");
    	}
    	String httpUrl=config.getValue("interface")+"/white/updateisfailure.do?whitelistId="+whitelistId+"&periodvalidity="+periodvalidity+"&chargeTimeType="+chargeTimeType+"&token="+config.getTokenToMd5();
    	String res=HttpUtil.request_post(httpUrl, "");
    	String code=JSONObject.fromObject(res).getString("code");
    	if(code.equals("200")){
    		return new Result(200,"�޸İ������ɹ�!");
    	}
		return new Result(3002,"�޸İ�����ʧ��");
    }
}
