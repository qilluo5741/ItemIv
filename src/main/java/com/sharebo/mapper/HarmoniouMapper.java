package com.sharebo.mapper;

import java.util.List;
import java.util.Map;

import com.sharebo.entity.dto.Harmoniou;

public interface HarmoniouMapper {
	public List<Harmoniou> getHarmonioulistAll(Map<String,Object> map);
	public int selectHarmonioulistCount();
}
