package com.sharebo.service;

import java.util.List;


import com.sharebo.entity.dto.CommunityDto;

public interface WhiteListService {
	/**
	 * ͨ��userid��ѯcommval,commName
	 * @param userId
	 * @return
	 */
	public List<CommunityDto> getCommIdByUserId(String userId);
}
