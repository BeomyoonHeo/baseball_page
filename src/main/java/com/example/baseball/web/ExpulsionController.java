package com.example.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.baseball.service.ExpulsionService;
import com.example.baseball.service.PlayerService;
import com.example.baseball.web.dto.response.PlayerListDto;
import com.example.baseball.web.dto.response.expulsion.ExpulsionDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ExpulsionController {
	
	private final ExpulsionService expulsionService;
	private final PlayerService playerService;
	@GetMapping("/expulsion")
	public String expulsionMain(Model model) {
		List<ExpulsionDto> list = expulsionService.퇴출선수목록보기();
		model.addAttribute("playerlist", list);
		return "/expulsion/main";
	}
	
	@GetMapping("/join_expulsion_form")
	public String createExpulsion(Model model) {
		List<PlayerListDto> list = playerService.플레이어전체보기();
		model.addAttribute("playerlist", list);
		return "/expulsion/createExpulsion";
	}

}
