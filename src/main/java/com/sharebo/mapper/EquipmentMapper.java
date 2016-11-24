package com.sharebo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EquipmentMapper {
	/**
	 * 通过userid查询关联的小区标识
	 * @param userid
	 * @return
	 */
	public List<String> selectCommValByUserId(@Param("userid")String userid);

}
