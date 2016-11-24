package com.sharebo.service;

import java.util.List;
import java.util.Map;


import com.sharebo.entity.dto.CommunityDto;

public interface CommunityService {
	/**
	 * 分页查询小区
	 * @param map
	 * @return
	 */
	public List<CommunityDto> setCommunitylistAll(Map<String,Object> map);
	/**
	 * 根据分页查总数
	 * @return
	 */
	public int selectCommunitylistCount(String commName);
	public int selectCommunitylistCounts();
	/**
	 * 查询小区信息
	 * @param commId
	 * @return
	 */
	public List<CommunityDto> getCommunityInfo(Map<String,Object> map);
	/**
	 * 查询小区总数
	 * @param commId
	 * @return
	 */
	public int getCommunityCount(String commId);
	/**
	 * 通过userId查询commId
	 * @param userId
	 * @return
	 */
	public List<String> selectCommIdByUserId(String userId);
}
