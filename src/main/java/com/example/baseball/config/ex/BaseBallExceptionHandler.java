package com.example.baseball.config.ex;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.baseball.domain.utill.ResponseScript;

@ControllerAdvice
public class BaseBallExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public @ResponseBody String backToMainPage() {
		return new ResponseScript().backMainPage();
	}

}
