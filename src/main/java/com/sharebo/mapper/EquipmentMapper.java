package com.sharebo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EquipmentMapper {
	/**
	 * ͨ��userid��ѯ������С����ʶ
	 * @param userid
	 * @return
	 */
	public List<String> selectCommValByUserId(@Param("userid")String userid);

}
