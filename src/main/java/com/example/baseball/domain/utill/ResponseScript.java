package com.example.baseball.domain.utill;

public class ResponseScript {
	private StringBuilder builder;
	
	public String backMainPage() {
		builder = new StringBuilder();
		builder.append("<script>");
		builder.append("alert('잘못된 요청입니다.');");
		builder.append("location.href='/';");
		builder.append("</script>");
		return builder.toString();
	}
}
