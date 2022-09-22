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
import com.example.baseball.web.dto.ResponseDto;
import com.example.baseball.web.dto.request.StadiumDto;
import com.example.baseball.web.dto.response.PlayerListDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	public final PlayerService playerService;
	
	@GetMapping("/player")
	public String test(Model model) {
		List<PlayerListDto> list = playerService.플레이어전체보기();
		for (PlayerListDto playerListDto : list) {
			System.out.println(playerListDto.getTeamname());
		}
		model.addAttribute("playerlist", list);
		return "/player/main";
	}
	
	@GetMapping("/join_player_form")
	public String joinStardiumForm() {
		return "/stadium/joinStadium";
	}
	
	@PostMapping("/player/create")
	public @ResponseBody ResponseDto<?> createStadium(@RequestBody StadiumDto stardiumDto){
		return new ResponseDto<>(1, "", null);
	}
	
	@GetMapping("/player/update/{id}")
	public String stadiumUpdateForm(@PathVariable Integer id) {
		System.out.println(id);
		return null;
	}
	@DeleteMapping("/player/delete/{id}")
	public @ResponseBody ResponseDto<?> stadiumDelete(@PathVariable Integer id) {
		return new ResponseDto<>(1, "야구장 삭제 완료", null);
	}
}
