package com.sharebo.service;

import java.util.List;


public interface FeeService {

	public String getUserId(String userId);

	// 得到全部停车场
	public List<com.sharebo.entity.dto.CommunityDto> getAllComm(String userId);
}
