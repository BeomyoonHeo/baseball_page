package com.example.baseball.domain.player;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.baseball.web.dto.request.player.CreatePlayerDto;
import com.example.baseball.web.dto.response.player.PlayerListDto;

public interface PlayerDao {
	 
	public List<PlayerListDto> findAll(Integer id);
	public void insert(CreatePlayerDto createPlayerDto);
	public void deleteById(Integer id);
	public List<Map<String, Object>> findGroupForPosition(@Param("list") List<String> list);
	public void update(Integer id);
}
