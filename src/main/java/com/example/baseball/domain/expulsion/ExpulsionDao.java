package com.example.baseball.domain.expulsion;

import java.util.List;

import com.example.baseball.web.dto.response.expulsion.ExpulsionDto;

public interface ExpulsionDao {
	
	public List<ExpulsionDto> findAll();

}
