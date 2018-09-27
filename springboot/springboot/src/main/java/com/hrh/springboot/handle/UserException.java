package com.hrh.springboot.handle;

public class UserException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	public UserException(Integer status,String msg){
		super(msg);
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
