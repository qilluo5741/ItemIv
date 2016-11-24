package com.sharebo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebo.entity.dto.Harmoniou;
import com.sharebo.mapper.HarmoniouMapper;
import com.sharebo.service.HarmoniouService;
@Service
public class HarmoniouServiceImpl implements HarmoniouService {
	@Autowired
	private HarmoniouMapper mapper;
	@Override
	public List<Harmoniou> getHarmonioulistAll(Map<String, Object> map) {
		return mapper.getHarmonioulistAll(map);
	}
	@Override
	public int selectHarmonioulistCount() {
		return mapper.selectHarmonioulistCount();
	}
}
