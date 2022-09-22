package com.example.baseball.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTeamDto {
	private String name;
	private Integer stadiumId;
}
