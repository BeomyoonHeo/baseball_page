package com.example.baseball.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseball.domain.expulsion.ExpulsionDao;
import com.example.baseball.domain.player.PlayerDao;
import com.example.baseball.web.dto.request.expulsion.CreateExpulsionDto;
import com.example.baseball.web.dto.response.expulsion.ExpulsionDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpulsionService {
	
	private final ExpulsionDao expulsionDao;
	private final PlayerDao playerDao;
	
	public List<ExpulsionDto>퇴출선수목록보기(){
		List<ExpulsionDto> list = expulsionDao.findAll();
		return list;
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void 퇴출선수등록(CreateExpulsionDto dto) {
		expulsionDao.insert(dto);
		//playerDao.deleteById(dto.getPlayerId());
	}

}
