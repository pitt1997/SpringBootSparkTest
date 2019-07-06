package com.cn.springboot04web.entities;
/**
 * 
成功的时候，只返回数据。
失败的话，那么就返回CodeMsg。（里面包含错误码以及错误信息）
 *
 */
public class CodeMsg {
	private int code;
	private String msg;
	//通用异常
	public static CodeMsg SUCCESS=new CodeMsg(0,"success");
	public static CodeMsg SERVER_ERROR=new CodeMsg(500100,"服务端异常!");
	public CodeMsg(int code,String msg) {
		this.code=code;
		this.msg=msg;
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
	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
	
}
