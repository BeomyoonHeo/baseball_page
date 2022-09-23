package com.example.baseball.domain.team;

import java.util.List;

import com.example.baseball.web.dto.request.CreateTeamDto;
import com.example.baseball.web.dto.response.TeamListDto;

public interface TeamDao {
	public List<TeamListDto> findAll();
	public void insert(CreateTeamDto createTeamDto);
	public void deleteById(Integer id);
}
