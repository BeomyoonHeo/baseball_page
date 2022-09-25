package com.example.baseball.domain.player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	private Integer id;
	private String name;
	private Integer teamId;
	private String position;
	private String createDate;
	private boolean expulsion;
}
