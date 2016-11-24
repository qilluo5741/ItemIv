package com.sharebo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sharebo.entity.dto.CommunityDto;

public interface CommunityMapper {
	/**
	 * ģ����ҳ��ѯС��
	 * @param map
	 * @return
	 */
	public List<CommunityDto> setCommunitylistAll(Map<String,Object> map);
	/**
	 * ģ�����ݷ�ҳ������
	 * @return
	 */
	public int selectCommunitylistCount(@Param("commName")String commName);
	public int selectCommunitylistCounts();
	/**
	 * ��ѯС����Ϣ
	 * @param commId
	 * @return
	 */
	public List<CommunityDto> getCommunityInfo(Map<String,Object> map);
	/**
	 * ��ѯС������
	 * @param commId
	 * @return
	 */
	public int getCommunityCount(@Param("commId")String commId);
	/**
	 * ͨ��userId��ѯcommId
	 * @param userId
	 * @return
	 */
	public List<String> selectCommIdByUserId(@Param("userId")String userId);
}
