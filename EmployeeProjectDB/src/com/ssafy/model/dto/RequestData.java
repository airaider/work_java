package com.ssafy.model.dto;

public class RequestData {
	private String command;
	private String data;
	public RequestData() {}
	public RequestData(String command, String data) {
		this.command = command;
		this.data = data;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestData [command=").append(command).append(", data=").append(data).append("]");
		return builder.toString();
	}
}
