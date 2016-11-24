package com.sharebo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sharebo.config.InterfaceApiConfig;
import com.sharebo.entity.Pager;
import com.sharebo.entity.Result;
import com.sharebo.entity.UserInfo;
import com.sharebo.entity.dto.CommunityDto;
import com.sharebo.service.CommunityService;
import com.sharebo.service.EquipmentService;
import com.sharebo.service.FeeService;
import com.sharebo.util.HttpUtil;

import net.sf.json.JSONObject;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("commun")
public class CommunityController {
	//private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService service;
	@Autowired
	private FeeService Fservice;
	private InterfaceApiConfig config;
	/**
	 * commun/getcommunitylist.do
	 * @param mp
	 * @param pageIndex
	 * @param pageSize
	 * @param key
	 * @return
	 */
    @RequestMapping("getcommunitylist")
	public String getCommunitylist(ModelMap mp,Integer pageIndex,Integer pageSize,String key,HttpSession session){
	    	UserInfo user=(UserInfo) session.getAttribute("user");
	    	if (user == null) {
				return "login";
			}
			String userId=Fservice.getUserId(user.getUserId());
			if(userId==null){//���˺Ų�����ҵ
				userId=user.getUserId();;
			}
			List<String> list=service.selectCommIdByUserId(userId);
			StringBuffer sb=new StringBuffer();
			if(list!=null){
				for(int i=0;i<list.size();i++){
					sb.append("'"+list.get(i)+"'");
					if(i<list.size()-1){
						sb.append(",");
					}
				}
			}
        	Pager<CommunityDto> pager=new Pager<CommunityDto>();
    		pager.setPageIndex((pageIndex==null?1:pageIndex));
    		pager.setPageSize(10);
    		
			//��ѯ����
    		if(key==null||key==""){
    			System.out.println("keyֵ�ǿյ�");
    			Map<String, Object> map=new HashMap<String, Object>();
    			//���ÿ�ʼ
    			int pageBegin=(pager.getPageIndex()-1)*pager.getPageSize();
    			map.put("pageBegin", pageBegin);
    			map.put("pageSize", pager.getPageSize());
    			map.put("commId", sb.toString());
    			pager.setList(service.getCommunityInfo(map));
    			pager.setTotalNumber(service.getCommunityCount(sb.toString()));
    		}
    		else{
    			System.out.println("key��ֵΪ:"+key);
    			Map<String, Object> map=new HashMap<String, Object>();
        		//���ÿ�ʼ
        		int pageBegin=(pager.getPageIndex()-1)*pager.getPageSize();
        		map.put("pageBegin", pageBegin);
        		map.put("pageSize", pager.getPageSize());
        		map.put("commName",key);
        		//��ѯ����
        		pager.setList(service.setCommunitylistAll(map));
    			pager.setTotalNumber(service.selectCommunitylistCount(key));
    		}
    		pager.setTotalPages();//������ҳ��
    		mp.addAttribute("pager", pager);
    		return "CommManager";
    	}
    /**
     * ��ѯС����Ϣ
     * @param mp
     * @param pageIndex
     * @param pageSize
     * @param session
     * @return
     */
    @RequestMapping("getCommunityInfo")
    public String getCommunityInfo(ModelMap mp,Integer pageIndex,Integer pageSize,String commName,HttpSession session){
    	UserInfo user=(UserInfo) session.getAttribute("user");
    	if (user == null) {
			return "login";
		}
		String userId=Fservice.getUserId(user.getUserId());
		if(userId==null){//���˺Ų�����ҵ
			userId=user.getUserId();;
		}
		List<String> list=service.selectCommIdByUserId(userId);
		StringBuffer sb=new StringBuffer();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				sb.append("'"+list.get(i)+"'");
				if(i<list.size()-1){
					sb.append(",");
				}
			}
		}
		System.out.println(sb);
		Pager<CommunityDto> pager=new Pager<CommunityDto>();
		pager.setPageIndex((pageIndex==null?1:pageIndex));
		pager.setPageSize(10);
		Map<String, Object> map=new HashMap<String, Object>();
		//���ÿ�ʼ
		int pageBegin=(pager.getPageIndex()-1)*pager.getPageSize();
		map.put("pageBegin", pageBegin);
		map.put("pageSize", pager.getPageSize());
		map.put("commId", sb.toString());
		pager.setList(service.getCommunityInfo(map));   
		pager.setTotalNumber(service.getCommunityCount(sb.toString()));
		pager.setTotalPages();//������ҳ��
		mp.addAttribute("pager", pager);
		return "CommManager";
    }
    /**
     * ��ѯС��ʣ�೵λ��
     * @param commId
     * @return
     */
    @RequestMapping("getCommPsCount")
    @ResponseBody
    public Result getCommPsCount(String commId){
    	if(commId==null){
    		return new Result(3001,"�����������Ϊ��");
    	}
    	String httpUrl=config.getValue("interface")+"/community/getCommPsCount.do?commId="+commId+"&token="+config.getTokenToMd5();
    	String res=HttpUtil.request_post(httpUrl, "");
    	if(res==null){
    		return new Result(3002,"��ѯ��λ��ʧ��");
    	}
    	String result=JSONObject.fromObject(res).getString("result");
    	return new Result(200,"��ѯ��λ���ɹ�",result);
    }
    /**
     * �޸ĳ�λ��
     * @param commId
     * @param psCount
     * @return
     */
    @RequestMapping("updateCommPsCount")
    @ResponseBody
    public Result updateCommPscount(String commId,int psCount){
    	if(commId==null||psCount==0){
    		return new Result(3003,"�����������Ϊ��");
    	}
    	String httpUrl=config.getValue("interface")+"/community/updateparkCount.do?commId="+commId+"&psCount="+psCount+"&token="+config.getTokenToMd5();
    	String res=HttpUtil.request_post(httpUrl, "");
    	String code=JSONObject.fromObject(res).getString("code");
    	if(code.equals("200")){
    		return new Result(200,"�޸ĳ�λ���ɹ�");
    	}
    	return new Result(3004,"�޸ĳ�λ��ʧ��");
    }
    /**
     * ��ѯС���Ƿ�����������������
     * @param commId
     * @return
     */
    @RequestMapping("getisBanOnForeignCars")
    @ResponseBody
    public Result getisBanOnForeignCars(String commId){
    	if(commId==null){
    		return new Result(3001,"�����������Ϊ��");
    	}
    	String httpUrl=config.getValue("interface")+"/community/getisBanOnForeignCars.do?commId="+commId+"&token="+config.getTokenToMd5();
    	String res=HttpUtil.request_post(httpUrl, "");
    	if(res==null){
    		return new Result(3002,"��ѯʧ��");
    	}
    	String result=JSONObject.fromObject(res).getString("result");
    	return new Result(200,"��ѯ�ɹ�",result);
    }
    /**
     * �޸�С���Ƿ������������������״̬
     * @param commId
     * @param isBanOnForeignCars
     * @return
     */
    @RequestMapping("updateisBanOnForeignCars")
    @ResponseBody
    public Result updateisBanOnForeignCars (String commId,Integer isBanOnForeignCars){
		if(commId==null||isBanOnForeignCars==null){
			return new Result(3001,"�����������Ϊ��");
		}
		String httpUrl=config.getValue("interface")+"/community/updateisBanOnForeignCars.do?commId="+commId+"&isBanOnForeignCars="+isBanOnForeignCars+"&token="+config.getTokenToMd5();
		String res=HttpUtil.request_post(httpUrl, "");
		String code=JSONObject.fromObject(res).getString("code");
		if(code.equals("200")){
			return new Result(200,"�޸ĳɹ�");
		}
		return new Result(3002,"�޸�ʧ��");
    }
    }
