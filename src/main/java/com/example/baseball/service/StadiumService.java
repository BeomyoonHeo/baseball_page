package com.example.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.example.baseball.domain.stadium.Stadium;
import com.example.baseball.domain.stadium.StadiumDao;
import com.example.baseball.web.dto.request.stadium.StadiumDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class StadiumService {
	
	private final StadiumDao stadiumDao;
	
	public List<Stadium> 야구장목록보기(){
		List<Stadium> stadiumlist = stadiumDao.findAll();
		return stadiumlist;
	}
	public Stadium 야구장이름검색(StadiumDto stardiumDto) {
		Stadium stadium = stadiumDao.findByName(stardiumDto);
		return stadium;
	}
	public void 야구장만들기(StadiumDto stardiumDto) {
		stadiumDao.insert(stardiumDto);
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void 야구장삭제(List<Integer> id) {
		for (Integer integer : id) {
			stadiumDao.deleteById(integer);
		}
		
	}
}
