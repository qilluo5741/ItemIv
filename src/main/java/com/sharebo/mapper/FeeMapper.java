package com.sharebo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FeeMapper {
	//�û���ǰ�û��õ������û�
	public String getUserId(@Param("userId")String userId);
	//�õ�ȫ��ͣ����
	public List<com.sharebo.entity.dto.CommunityDto> getAllComm(@Param("userId")String userId);
}
