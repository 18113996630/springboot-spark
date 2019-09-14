package com.hrong.springbootspark.vo;

/**
 * @author huangrong
 */
public class Result<T> {
	private Integer code;

	private String message;

	private T data;

	public static <T> Result success(T data) {
		Result result = new Result();
		result.setCode(200);
		result.setMessage("success");
		result.setData(data);
		return result;
	}

	public static <T> Result err(Integer code, String message) {
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
