package com.sharebo.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EquipmentService {
	/**
	 * ͨ��userid��ѯ������С����ʶ
	 * @param userid
	 * @return
	 */
	public List<String> selectCommValByUserId(@Param("userid")String userid);

}
