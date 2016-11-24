package com.sharebo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.entity.dto.CommunityDto;
import com.sharebo.mapper.WhiteListMapper;
import com.sharebo.service.WhiteListService;
@Service
public class WhiteListServiceImpl implements WhiteListService {
	@Autowired
	private WhiteListMapper mapper;
    
	/**
	 * Í¨¹ýuserid²éÑ¯commval,commName
	 * @param userId
	 * @return
	 */
	@Override
	public List<CommunityDto> getCommIdByUserId(String userId) {
		return mapper.getCommIdByUserId(userId);
	}
}
