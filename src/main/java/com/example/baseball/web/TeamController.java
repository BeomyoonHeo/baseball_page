package com.example.baseball.web;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.baseball.domain.stadium.Stadium;
import com.example.baseball.service.StadiumService;
import com.example.baseball.service.TeamService;
import com.example.baseball.web.dto.ResponseDto;
import com.example.baseball.web.dto.request.team.CreateTeamDto;
import com.example.baseball.web.dto.response.team.TeamListDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {
	
	private final TeamService teamService;
	
	@GetMapping("/team")
	public String test(Model model) {
		List<TeamListDto> list = teamService.팀전체보기();
		model.addAttribute("teamlist", list);
		return "/team/main";
	}
	
	@GetMapping("/join_team_form")
	public String joinStardiumForm(Model model) {
		List<Stadium> list = teamService.야구장목록보기();
		model.addAttribute("Stadiumlist", list);
		return "/team/joinTeam";
	}
	
	@PostMapping("/team/create")
	public @ResponseBody ResponseDto<?> createTeam(@RequestBody CreateTeamDto createTeamDto){
		teamService.팀생성(createTeamDto);
		return new ResponseDto<>(1, "", null);
	}
	
	@GetMapping("/team/update/{id}")
	public String stadiumUpdateForm(@PathVariable Integer id) {
		return null;
	}
	
	@DeleteMapping("/team/delete")
	public @ResponseBody ResponseDto<?> stadiumDelete(@RequestParam(value = "deletelist[]") List<Integer> id) {
		teamService.팀삭제(id);
		return new ResponseDto<>(1, "팀 삭제 완료", null);
	}
}
