package com.example.baseball.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseball.domain.player.PlayerDao;
import com.example.baseball.domain.team.TeamDao;
import com.example.baseball.web.dto.request.player.CreatePlayerDto;
import com.example.baseball.web.dto.response.player.PlayerListDto;
import com.example.baseball.web.dto.response.player.PlayerPositionForGroup;
import com.example.baseball.web.dto.response.team.TeamListDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {
	
	private final PlayerDao playerDao;
	private final TeamDao teamDao;
	
	
	public List<TeamListDto> 팀전체보기(){
		List<TeamListDto> list = teamDao.findAll();
		return list;
	}
	
	public List<String> 팀이름가져오기(){
		List<String> list = teamDao.findTeamName();
		return list;
	}
	
	public List<PlayerListDto> 플레이어전체보기(Integer id){
		
		List<PlayerListDto> list = playerDao.findAll(id);
		return list;
	}
	
	public List<Map<String, Object>> 포지션별플레이어보기(){
		List<String> list = 팀이름가져오기();
		List<Map<String, Object>> list2 = playerDao.findGroupForPosition(list);
		return list2;
	}
	
	public void 플레이어등록(CreatePlayerDto createPlayerDto) {
		playerDao.insert(createPlayerDto);
	}
	
	public void 플레이어정보수정(Integer id) {
		playerDao.update(id);
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void 플레이어삭제(List<Integer> id) {
		for (Integer integer : id) {
			playerDao.deleteById(integer);
		}
	}
}
