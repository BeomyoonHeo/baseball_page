package com.example.baseball.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseball.domain.expulsion.Expulsion;
import com.example.baseball.domain.expulsion.ExpulsionDao;
import com.example.baseball.domain.player.PlayerDao;
import com.example.baseball.domain.team.TeamDao;
import com.example.baseball.web.dto.request.expulsion.CreateExpulsionDto;
import com.example.baseball.web.dto.response.expulsion.ExpulsionDto;
import com.example.baseball.web.dto.response.player.PlayerListDto;
import com.example.baseball.web.dto.response.team.TeamListDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpulsionService {
	
	private final ExpulsionDao expulsionDao;
	private final PlayerDao playerDao;
	private final TeamDao teamDao;
	
	public List<PlayerListDto> 플레이어전체보기(Integer id){
		List<PlayerListDto> list = playerDao.findAll(id);
		return list;
	}
	
	public List<TeamListDto> 팀전체보기(){
		List<TeamListDto> list = teamDao.findAll();
		return list;
	}
	
	public List<ExpulsionDto>퇴출선수목록보기(Integer id){
		List<ExpulsionDto> list = expulsionDao.findAll(id);
		return list;
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void 퇴출선수등록(CreateExpulsionDto dto) {
		expulsionDao.insert(dto);
		playerDao.update(dto.getPlayerId());
	}

}
