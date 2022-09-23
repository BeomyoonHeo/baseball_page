package com.example.baseball.web.dto.request.expulsion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateExpulsionDto {
	private Integer playerId;
	private String reason;
	

}
