package com.example.baseball.service;


import java.util.List;

import org.springframework.stereotype.Service;


import com.example.baseball.domain.expulsion.ExpulsionDao;
import com.example.baseball.web.dto.response.expulsion.ExpulsionDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpulsionService {
	
	private final ExpulsionDao expulsionDao;
	
	public List<ExpulsionDto>퇴출선수목록보기(){
		List<ExpulsionDto> list = expulsionDao.findAll();
		return list;
	}

}
