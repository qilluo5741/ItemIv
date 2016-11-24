package com.sharebo.service;

import java.util.List;
import java.util.Map;

import com.sharebo.entity.dto.Harmoniou;

public interface HarmoniouService {
	public List<Harmoniou> getHarmonioulistAll(Map<String,Object> map);
	public int selectHarmonioulistCount();
}
