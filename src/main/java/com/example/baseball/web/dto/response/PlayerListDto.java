package com.example.baseball.web.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerListDto {
	private Integer id;
	private Integer ROW;
	private String name;
	private String teamname;
	private String position;
	private String createDate;

}
