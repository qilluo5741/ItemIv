package com.sharebo.service;

import java.util.List;


public interface FeeService {

	public String getUserId(String userId);

	// �õ�ȫ��ͣ����
	public List<com.sharebo.entity.dto.CommunityDto> getAllComm(String userId);
}
