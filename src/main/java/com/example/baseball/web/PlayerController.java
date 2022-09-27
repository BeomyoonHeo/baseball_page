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
import com.example.baseball.service.PlayerService;
import com.example.baseball.service.TeamService;
import com.example.baseball.web.dto.ResponseDto;
import com.example.baseball.web.dto.request.player.CreatePlayerDto;
import com.example.baseball.web.dto.response.player.PlayerListDto;
import com.example.baseball.web.dto.response.player.PlayerPositionForGroup;
import com.example.baseball.web.dto.response.team.TeamListDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	
	@GetMapping("/player")
	public String playerList(Model model) {
		List<PlayerListDto> list = playerService.플레이어전체보기(null);
		List<TeamListDto> list2 = playerService.팀전체보기();
		model.addAttribute("playerlist", list);
		model.addAttribute("teamlist", list2);
		return "/player/main";
	}
	
	@GetMapping("/player/groupteam/{id}")
	public @ResponseBody ResponseDto<?> playerListToGroup(@PathVariable Integer id){
		if(id == 0) {
			id = null;
		}
		List<PlayerListDto> list = playerService.플레이어전체보기(id);
		return new ResponseDto<>(1, "완료", list);
	}
	
	@GetMapping("/player/position")
	public String PlayerListForPosition(Model model) {
		List<PlayerPositionForGroup> list = playerService.포지션별플레이어보기();
		model.addAttribute("playerlist", list);
		return "/player/groupforposition";
	}
	
	@GetMapping("/join_player_form")
	public String joinStardiumForm(Model model) {
		List<TeamListDto> list = playerService.팀전체보기();
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
	@DeleteMapping("/Player/delete/")
	public @ResponseBody ResponseDto<?> stadiumDelete(@RequestParam(value = "deletelist[]") List<Integer> id) {
		playerService.플레이어삭제(id);
		return new ResponseDto<>(1, "플레이어 삭제 완료", null);
	}
}
