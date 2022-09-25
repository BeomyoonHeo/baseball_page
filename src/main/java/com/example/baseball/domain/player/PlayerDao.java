package com.example.baseball.domain.player;

import java.util.List;

import com.example.baseball.web.dto.request.player.CreatePlayerDto;
import com.example.baseball.web.dto.response.player.PlayerListDto;
import com.example.baseball.web.dto.response.player.PlayerPositionForGroup;

public interface PlayerDao {
	
	public List<PlayerListDto> findAll(Integer id);
	public void insert(CreatePlayerDto createPlayerDto);
	public void deleteById(Integer id);
	public List<PlayerPositionForGroup> findGroupForPosition();
}
