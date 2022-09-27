package com.example.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseball.domain.player.PlayerDao;
import com.example.baseball.domain.stadium.Stadium;
import com.example.baseball.domain.stadium.StadiumDao;
import com.example.baseball.domain.team.Team;
import com.example.baseball.domain.team.TeamDao;
import com.example.baseball.web.dto.request.team.CreateTeamDto;
import com.example.baseball.web.dto.response.player.PlayerListDto;
import com.example.baseball.web.dto.response.team.TeamListDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService {
	
	private final TeamDao teamDao;
	private final StadiumDao stadiumDao;
	
	public List<TeamListDto> 팀전체보기(){
		List<TeamListDto> list = teamDao.findAll();
		return list;
	}
	
	public List<Stadium> 야구장목록보기(){
		List<Stadium> list = stadiumDao.findAll();
		return list;
	}
	
	public void 팀생성(CreateTeamDto createTeamDto) {
		teamDao.insert(createTeamDto);
	}
	
	@Transactional(rollbackFor = {RuntimeException.class})
	public void 팀삭제(List<Integer> id) {
		for (Integer integer : id) {
			teamDao.deleteById(integer);
		}
		
	}
	
}
