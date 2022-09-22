package com.example.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.baseball.domain.player.PlayerDao;
import com.example.baseball.domain.team.Team;
import com.example.baseball.domain.team.TeamDao;
import com.example.baseball.web.dto.request.CreateTeamDto;
import com.example.baseball.web.dto.response.PlayerListDto;
import com.example.baseball.web.dto.response.TeamListDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService {
	private final TeamDao teamDao;
	
	public List<TeamListDto> 팀전체보기(){
		List<TeamListDto> list = teamDao.findAll();
		return list;
	}
	
	public void 팀생성(CreateTeamDto createTeamDto) {
		teamDao.insert(createTeamDto);
	}
	
}