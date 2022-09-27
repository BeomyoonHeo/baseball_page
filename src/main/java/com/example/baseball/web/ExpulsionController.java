package com.example.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.baseball.domain.expulsion.Expulsion;
import com.example.baseball.service.ExpulsionService;
import com.example.baseball.service.PlayerService;
import com.example.baseball.service.TeamService;
import com.example.baseball.web.dto.ResponseDto;
import com.example.baseball.web.dto.request.expulsion.CreateExpulsionDto;
import com.example.baseball.web.dto.response.expulsion.ExpulsionDto;
import com.example.baseball.web.dto.response.player.PlayerListDto;
import com.example.baseball.web.dto.response.team.TeamListDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ExpulsionController {
	
	private final ExpulsionService expulsionService;
	
	
	@GetMapping({"/expulsion/{id}", "/expulsion"})
	public String expulsionMain(@PathVariable(required = false) Integer id, Model model) {
		List<ExpulsionDto> list = expulsionService.퇴출선수목록보기(id);
		List<TeamListDto> list2 = expulsionService.팀전체보기();
		model.addAttribute("playerlist", list);
		model.addAttribute("teamlist", list2);
		return "/expulsion/main";
	}
	
	
	@GetMapping("/expulsion/team/{id}")
	public @ResponseBody ResponseDto<?> teamForm(@PathVariable Integer id){
		
		List<ExpulsionDto> list = expulsionService.퇴출선수목록보기(id);
		return new ResponseDto<>(1, "완료", list);
	}
	
	@GetMapping("/join_expulsion_form")
	public String createExpulsionForm(Model model) {
		List<PlayerListDto> list = expulsionService.플레이어전체보기(null);
		model.addAttribute("playerlist", list);
		return "/expulsion/createExpulsion";
	}
	
	@PostMapping("/expulsion/create")
	public @ResponseBody ResponseDto<?> createExpulsion(@RequestBody CreateExpulsionDto expulsionDto){
		expulsionService.퇴출선수등록(expulsionDto);
		return new ResponseDto<>(1, "퇴출등록완료", null);
	}

}
