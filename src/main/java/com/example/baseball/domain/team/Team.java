package com.example.baseball.domain.team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
	private Integer id;
	private Integer stadiumId;
	private String name;
	private String createDate;
}
