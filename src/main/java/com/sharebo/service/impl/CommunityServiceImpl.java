package com.sharebo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.entity.dto.CommunityDto;
import com.sharebo.mapper.CommunityMapper;
import com.sharebo.service.CommunityService;
@Service
public class CommunityServiceImpl implements CommunityService {
	@Autowired
	private CommunityMapper mapper;
	@Override
	public List<CommunityDto> setCommunitylistAll(Map<String, Object> map) {
		return mapper.setCommunitylistAll(map);
	}
	@Override
	public int selectCommunitylistCount(String commName) {
		return mapper.selectCommunitylistCount(commName);
	}
	@Override
	public int selectCommunitylistCounts() {
		return mapper.selectCommunitylistCounts();
	}
	/**
	 * 查询小区信息
	 */
	@Override
	public List<CommunityDto> getCommunityInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.getCommunityInfo(map);
	}
	/**
	 * 查询小区总数
	 */
	@Override
	public int getCommunityCount(String commId) {
		// TODO Auto-generated method stub
		return mapper.getCommunityCount(commId);
	}
	@Override
	public List<String> selectCommIdByUserId(String userId) {
		// TODO Auto-generated method stub
		return mapper.selectCommIdByUserId(userId);
	}
}
