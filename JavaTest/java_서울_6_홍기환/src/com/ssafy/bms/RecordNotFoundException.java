package com.ssafy.bms;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(){
		super("데이터가 없습니다");
	}
	public RecordNotFoundException(String msg){
		super(msg);
	}
}
