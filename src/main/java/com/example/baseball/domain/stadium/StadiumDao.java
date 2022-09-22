package com.example.baseball.domain.stadium;

import java.util.List;

import com.example.baseball.web.dto.request.StadiumDto;

public interface StadiumDao {
	public List<Stadium> findAll();
	public void insert(StadiumDto stardiumDto);
	public Stadium findByName(StadiumDto stardiumDto);
	public void deleteById(Integer id);
	public void update(Stadium stadium);
}
