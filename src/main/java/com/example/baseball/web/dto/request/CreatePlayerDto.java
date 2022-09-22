package com.example.baseball.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePlayerDto {
	private String name;
	private Integer teamId;
	private String position;
	
}
