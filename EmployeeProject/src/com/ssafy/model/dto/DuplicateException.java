package com.ssafy.model.dto;

public class DuplicateException extends RuntimeException{
	public DuplicateException() {
		super("이미 등록된 사원 번호입니다.");
	}
	public DuplicateException(String msg) {
		super(msg);
	}
}
