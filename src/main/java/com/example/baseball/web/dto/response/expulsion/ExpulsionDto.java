package com.example.baseball.web.dto.response.expulsion;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExpulsionDto {
	private Integer ROW;
	private String teamname;
	private String position;
	private String name;
	private String reason;
	private String CreateDate;

}
