package com.sharebo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.dto.CommunityDto;

public interface WhiteListMapper {
	/**
	 * Í¨¹ýuserid²éÑ¯commval,commName
	 * @param userId
	 * @return
	 */
	public List<CommunityDto> getCommIdByUserId(@Param("userId")String userId);
}
