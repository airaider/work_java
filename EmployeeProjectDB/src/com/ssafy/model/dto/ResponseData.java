package com.ssafy.model.dto;

public class ResponseData {
	private String command;
	private String result;
	private String error;
	public ResponseData() {}
	public ResponseData(String command, String result, String error) {
		this.command = command;
		this.result = result;
		this.error = error;
	}

	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseData [command=").append(command).append(", result=").append(result).append(", error=")
				.append(error).append("]");
		return builder.toString();
	}
}
