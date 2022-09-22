package com.example.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.baseball.domain.player.PlayerDao;
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
}
