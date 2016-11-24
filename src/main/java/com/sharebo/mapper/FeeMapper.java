package com.sharebo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FeeMapper {
	//用户当前用户得到最终用户
	public String getUserId(@Param("userId")String userId);
	//得到全部停车场
	public List<com.sharebo.entity.dto.CommunityDto> getAllComm(@Param("userId")String userId);
}
