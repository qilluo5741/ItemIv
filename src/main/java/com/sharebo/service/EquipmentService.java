package com.sharebo.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EquipmentService {
	/**
	 * 通过userid查询关联的小区标识
	 * @param userid
	 * @return
	 */
	public List<String> selectCommValByUserId(@Param("userid")String userid);

}
