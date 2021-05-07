package com.zhaobo.stream.controller;

import lombok.Getter;

/**
 * @author liushuijing (shuijing@shanshu.ai)
 * @date 2020/05/18
 */
@Getter
public enum MessageEnum {
	UNKNOWN_ERROR(-1, "未知错误！"),
	ERROR(500, "系统错误"),
	SUCCESS(0, "操作成功！"),
	NEED_LOGIN(1001,"请先登录"),
	LOGIN_FAIL(1002,"用户名密码不正确"),
	;
	private Integer code;
	private String message;

	MessageEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
