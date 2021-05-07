package com.zhaobo.stream.controller;

import lombok.Data;

/**
 * @author liushuijing (shuijing@shanshu.ai)
 * @date 2020/05/18
 */
@Data
public class Result<T> {

	private Integer code;

	private String message;

	private T data;

	public static <T> Result<T> success() {
		return success(null);
	}

	public static <T> Result<T> success(T data) {
		Result<T> result = new Result<T>();
		result.setMessage(MessageEnum.SUCCESS.getMessage());
		result.setCode(MessageEnum.SUCCESS.getCode());
		result.setData(data);
		return result;
	}

	public static <T> Result<T> error() {
		Result<T> result = new Result<>();
		result.setMessage(MessageEnum.ERROR.getMessage());
		result.setCode(MessageEnum.ERROR.getCode());
		return result;
	}

	public static <T> Result<T> error(MessageEnum messageEnum) {
		Result<T> result = new Result<>();
		result.setMessage(messageEnum.getMessage());
		result.setCode(messageEnum.getCode());
		return result;
	}

	public static <T> Result<T> error(String message) {
		Result<T> result = new Result<>();
		result.setMessage(message);
		result.setCode(MessageEnum.ERROR.getCode());
		return result;
	}

	public static <T> Result<T> error(String message,Integer code) {
		Result<T> result = new Result<>();
		result.setMessage(message);
		result.setCode(code);
		return result;
	}
}
