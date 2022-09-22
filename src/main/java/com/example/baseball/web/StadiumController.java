package com.example.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.baseball.domain.stadium.Stadium;
import com.example.baseball.service.StadiumService;
import com.example.baseball.web.dto.ResponseDto;
import com.example.baseball.web.dto.request.StardiumDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	
	public final StadiumService stadiumService;
	
	@GetMapping("/")
	public String test(Model model) {
		List<Stadium> stadiumlist = stadiumService.야구장목록보기();
		for (Stadium stadium : stadiumlist) {
			System.out.println(stadium.getId());
			System.out.println(stadium.getName());
			System.out.println(stadium.getCreateDate());
		}
		model.addAttribute("stadiumlist", stadiumlist);
		return "/boards/main";
	}
	
	@GetMapping("/join_stadium_form")
	public String joinStardiumForm() {
		return "/stadium/joinStadium";
	}
	
	@PostMapping("/stadium/create")
	public @ResponseBody ResponseDto<?> createStadium(@RequestBody StardiumDto stardiumDto){
		stadiumService.야구장만들기(stardiumDto);
		return new ResponseDto<>(1, "", null);
	}
}
