package com.ssafy.product;

public class CodeNotFound extends Exception {
	public CodeNotFound() {
		super("해당 제품을 찾을 수 없습니다.");
	}
	public CodeNotFound(String msg) {
		super(msg);
	}
	
}
