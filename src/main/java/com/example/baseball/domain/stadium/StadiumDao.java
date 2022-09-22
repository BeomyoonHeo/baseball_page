package com.example.baseball.domain.stadium;

import java.util.List;

import com.example.baseball.web.dto.request.StardiumDto;

public interface StadiumDao {
	public List<Stadium> findAll();
	public void insert(StardiumDto stardiumDto);
	public Stadium findByName(StardiumDto stardiumDto);
}
