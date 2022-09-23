package com.example.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseball.domain.player.PlayerDao;
import com.example.baseball.web.dto.request.CreatePlayerDto;
import com.example.baseball.web.dto.response.PlayerListDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {
	private final PlayerDao playerDao;
	
	public List<PlayerListDto> 플레이어전체보기(){
		
		List<PlayerListDto> list = playerDao.findAll();
		return list;
	}
	
	public void 플레이어등록(CreatePlayerDto createPlayerDto) {
		playerDao.insert(createPlayerDto);
	}
	@Transactional(rollbackFor = {RuntimeException.class})
	public void 플레이어삭제(List<Integer> id) {
		for (Integer integer : id) {
			playerDao.deleteById(integer);
		}
	}
}
