package com.ssafy.product.dto;

public class ProductException extends RuntimeException{
	public ProductException() {
		super("제품 정보 처리 중 오류 발생");
	}
	public ProductException(String msg) {
		super(msg);
	}
}

