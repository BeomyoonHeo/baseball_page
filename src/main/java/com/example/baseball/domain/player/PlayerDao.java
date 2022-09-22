package com.example.baseball.domain.player;

import java.util.List;

import com.example.baseball.web.dto.response.PlayerListDto;

public interface PlayerDao {
	
	public List<PlayerListDto> findAll();
	

}
