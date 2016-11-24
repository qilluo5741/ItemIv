package com.sharebo.service;

import java.util.List;
import java.util.Map;


import com.sharebo.entity.dto.CommunityDto;

public interface CommunityService {
	/**
	 * ��ҳ��ѯС��
	 * @param map
	 * @return
	 */
	public List<CommunityDto> setCommunitylistAll(Map<String,Object> map);
	/**
	 * ���ݷ�ҳ������
	 * @return
	 */
	public int selectCommunitylistCount(String commName);
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
	public int getCommunityCount(String commId);
	/**
	 * ͨ��userId��ѯcommId
	 * @param userId
	 * @return
	 */
	public List<String> selectCommIdByUserId(String userId);
}
