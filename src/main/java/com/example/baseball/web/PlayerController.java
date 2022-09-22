package com.example.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.baseball.domain.player.PlayerDao;
import com.example.baseball.domain.stadium.Stadium;
import com.example.baseball.service.PlayerService;
import com.example.baseball.service.StadiumService;
import com.example.baseball.service.TeamService;
import com.example.baseball.web.dto.ResponseDto;
import com.example.baseball.web.dto.request.CreatePlayerDto;
import com.example.baseball.web.dto.request.StadiumDto;
import com.example.baseball.web.dto.response.PlayerListDto;
import com.example.baseball.web.dto.response.TeamListDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	private final TeamService teamService;
	
	@GetMapping("/player")
	public String test(Model model) {
		List<PlayerListDto> list = playerService.플레이어전체보기();
		model.addAttribute("playerlist", list);
		return "/player/main";
	}
	
	@GetMapping("/join_player_form")
	public String joinStardiumForm(Model model) {
		List<TeamListDto> list = teamService.팀전체보기();
		model.addAttribute("teamlist", list);
		return "/player/joinPlayer";
	}
	
	@PostMapping("/player/create")
	public @ResponseBody ResponseDto<?> createStadium(@RequestBody CreatePlayerDto createPlayerDto){
		playerService.플레이어등록(createPlayerDto);
		return new ResponseDto<>(1, "", null);
	}
	
	@GetMapping("/player/update/{id}")
	public String stadiumUpdateForm(@PathVariable Integer id) {
		return null;
	}
	@DeleteMapping("/Player/delete/{id}")
	public @ResponseBody ResponseDto<?> stadiumDelete(@PathVariable Integer id) {
		playerService.플레이어삭제(id);
		return new ResponseDto<>(1, "플레이어 삭제 완료", null);
	}
}
