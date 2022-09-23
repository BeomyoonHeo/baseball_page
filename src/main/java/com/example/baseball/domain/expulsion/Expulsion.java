package com.example.baseball.domain.expulsion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expulsion {
	private Integer ROW;
	private Integer id;
	private String reason;
	private String teamname;
	private String position;
	private String playername;
	private String playerId;
	private String createDate;

}
