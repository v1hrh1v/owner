package com.hrh.springboot.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrh.springboot.entity.Result;
import com.hrh.springboot.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle  {

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result<Object> handle(Exception e){
		if (e instanceof UserException){
			return ResultUtil.error(((UserException) e).getStatus(), e.getMessage());
		} 
		return ResultUtil.error(-1, e.getMessage());
	}
	
}
