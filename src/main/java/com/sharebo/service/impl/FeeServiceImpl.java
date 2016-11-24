package com.sharebo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.entity.dto.CommunityDto;
import com.sharebo.mapper.FeeMapper;
import com.sharebo.service.FeeService;
@Service
public class FeeServiceImpl implements FeeService {
	@Autowired FeeMapper mapper;
	@Override
	public String getUserId(String userId) {
		// TODO Auto-generated method stub
		return mapper.getUserId(userId);
	}
	@Override
	public List<CommunityDto> getAllComm(String userId) {
		// TODO Auto-generated method stub
		return mapper.getAllComm(userId);
	}
}
