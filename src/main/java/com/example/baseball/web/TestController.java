package com.example.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.baseball.domain.stadium.Stadium;
import com.example.baseball.service.StadiumService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TestController {
	
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
}
