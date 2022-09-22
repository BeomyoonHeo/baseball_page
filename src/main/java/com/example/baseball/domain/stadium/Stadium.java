package com.example.baseball.domain.stadium;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stadium {
	private Integer id;
	private String name;
	private String createDate;
	private Integer ROW;
}
