package com.yc.S3Kyyblog.bean;

public class Result {
	private int code;//0失败 1成功
	private String msg;//消息
	private Object data;//返回数据
	
	public Result(String msg) {
		this.code = 0;
		this.msg = msg;
	}
	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
