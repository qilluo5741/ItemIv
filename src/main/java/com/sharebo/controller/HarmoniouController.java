package com.sharebo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sharebo.entity.Pagers;
import com.sharebo.entity.dto.Harmoniou;
import com.sharebo.service.HarmoniouService;

@Controller
@RequestMapping("harmon")
public class HarmoniouController {
	@Autowired
	private HarmoniouService service;
	/**
	 * harmon/getHarmonioulist.do
	 * @param mp
	 * @param pageIndex
	 * @param pageSize
	 * @param key
	 * @return
	 */
    @RequestMapping("getHarmonioulist")
	public String getCommunitylist(ModelMap mp,Integer pageIndex,Integer pageSize){
        	Pagers<Harmoniou> pager=new Pagers<Harmoniou>();
    		pager.setPageIndex((pageIndex==null?10:pageIndex));
    		pager.setPageSize(10);
    		Map<String, Object> map=new HashMap<String, Object>();
    		//���ÿ�ʼ
    		int pageBegin=(pager.getPageIndex()-1)*pager.getPageSize();
    		map.put("pageBegin", pageBegin);
    		map.put("pageSize", pager.getPageSize());
    		//��ѯ����
    		pager.setList(service.getHarmonioulistAll(map));
			//��ѯ����
			pager.setTotalRecords(service.selectHarmonioulistCount());
    		pager.setTotalPages();//������ҳ��
    		mp.addAttribute("pager",pager);
    		return "HarmoniouManager";
    }
}
