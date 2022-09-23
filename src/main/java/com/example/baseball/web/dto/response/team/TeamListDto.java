package com.example.baseball.web.dto.response.team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamListDto {
	private Integer id;
	private Integer ROW;
	private String name;
	private String stadiumname;
	private String createDate;

}
