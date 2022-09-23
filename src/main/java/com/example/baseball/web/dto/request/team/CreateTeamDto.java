package com.example.baseball.web.dto.request.team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTeamDto {
	private String name;
	private Integer stadiumId;
}
