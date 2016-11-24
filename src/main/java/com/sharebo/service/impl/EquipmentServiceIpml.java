package com.sharebo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.mapper.EquipmentMapper;
import com.sharebo.service.EquipmentService;
@Service
public class EquipmentServiceIpml implements EquipmentService {
	@Autowired
	private EquipmentMapper mapper;
	
	/**
	 * ͨ��userid��ѯ������С����ʶ
	 * @param userid
	 * @return
	 */
	@Override
	public List<String> selectCommValByUserId(String userid) {
		// TODO Auto-generated method stub
		return mapper.selectCommValByUserId(userid);
	}

}
