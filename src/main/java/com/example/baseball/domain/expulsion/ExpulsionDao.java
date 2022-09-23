package com.example.baseball.domain.expulsion;

import java.util.List;

import com.example.baseball.web.dto.request.expulsion.CreateExpulsionDto;
import com.example.baseball.web.dto.response.expulsion.ExpulsionDto;

public interface ExpulsionDao {
	
	public List<Expulsion> findAll();
	public void insert(CreateExpulsionDto dto);
}
