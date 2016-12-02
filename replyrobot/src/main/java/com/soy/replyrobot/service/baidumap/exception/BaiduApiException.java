package com.soy.replyrobot.service.baidumap.exception;

public class BaiduApiException extends RuntimeException {

	public BaiduApiException() {
		super();
	}

	public BaiduApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaiduApiException(String message) {
		super(message);
	}

	public BaiduApiException(Throwable cause) {
		super(cause);
	}
	
}
