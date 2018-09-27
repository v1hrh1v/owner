package com.hrh.springboot.utils;

import com.hrh.springboot.entity.Result;

public class ResultUtil {
	
	public static Result<Object> success(Object object){
		Result<Object> result = new Result<Object> ();
		result.setStatus(200);
		result.setMsg("ok");
		result.setData(object);
		return result;
	}
	
	public static Result<Object> success(){
		return success(null);
	}
	
	public static Result<Object> error(Integer status,String msg){
		Result<Object> result = new Result<Object> ();
		result.setStatus(status);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}
}
