package com.example.baseball.web.dto.response.player;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPositionForGroup {
	private List<String> positionKey;
	private List<String> teamKey;
	private List<Map<String, Object>> playerlist;
	
	
	
}
