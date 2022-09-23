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
import com.example.baseball.web.dto.ResponseDto;
import com.example.baseball.web.dto.request.stadium.StadiumDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	
	private final StadiumService stadiumService;
	
	@GetMapping({"/", "/stadium"})
	public String test(Model model) {
		List<Stadium> stadiumlist = stadiumService.야구장목록보기();
		model.addAttribute("stadiumlist", stadiumlist);
		return "/stadium/main";
	}
	
	@GetMapping("/join_stadium_form")
	public String joinStardiumForm() {
		return "/stadium/joinStadium";
	}
	
	@PostMapping("/stadium/create")
	public @ResponseBody ResponseDto<?> createStadium(@RequestBody StadiumDto stardiumDto){
		Stadium stadium = stadiumService.야구장이름검색(stardiumDto);
		if(stadium != null) {
			return new ResponseDto<>(-1, "야구장명 중복", null);
		}
		stadiumService.야구장만들기(stardiumDto);
		return new ResponseDto<>(1, "", null);
	}
	
	@GetMapping("/stadium/update/{id}")
	public String stadiumUpdateForm(@PathVariable Integer id) {
		return null;
	}
	
	@DeleteMapping("/stadium/delete")
	public @ResponseBody ResponseDto<?> stadiumDelete(@RequestParam(value = "deletelist[]")  List<Integer> id) {
		stadiumService.야구장삭제(id);
		return new ResponseDto<>(1, "야구장 삭제 완료", null);
	}
}
