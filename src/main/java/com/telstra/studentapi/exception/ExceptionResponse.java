package com.telstra.studentapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ExceptionResponse {

	String type;
	String exceptionCode;
	String exceptionMessage;
	String exceptionTrace;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getExceptionTrace() {
		return exceptionTrace;
	}
	public void setExceptionTrace(String exceptionTrace) {
		this.exceptionTrace = exceptionTrace;
	}
	public ExceptionResponse(String type, String exceptionCode, String exceptionMessage, String exceptionTrace) {
		this.type = type;
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
		this.exceptionTrace = exceptionTrace;
	}
	
	
}
