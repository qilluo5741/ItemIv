package com.sharebo.service;

import java.util.List;


import com.sharebo.entity.dto.CommunityDto;

public interface WhiteListService {
	/**
	 * Í¨¹ýuserid²éÑ¯commval,commName
	 * @param userId
	 * @return
	 */
	public List<CommunityDto> getCommIdByUserId(String userId);
}
