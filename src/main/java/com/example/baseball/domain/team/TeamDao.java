package com.example.baseball.domain.team;

import java.util.List;

import com.example.baseball.web.dto.request.team.CreateTeamDto;
import com.example.baseball.web.dto.response.team.TeamListDto;

public interface TeamDao {
	public List<TeamListDto> findAll();
	public List<String> findTeamName();
	public void insert(CreateTeamDto createTeamDto);
	public void deleteById(Integer id);
}
