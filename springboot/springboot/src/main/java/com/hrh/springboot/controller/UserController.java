package com.hrh.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrh.springboot.entity.Result;
import com.hrh.springboot.entity.User;
import com.hrh.springboot.service.UserService;
import com.hrh.springboot.utils.ResultUtil;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Result<Object> addUser( User user) throws Exception{
        userService.addUser(user);
        return ResultUtil.success();
    }
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public Result<Object> updateUser( User user) throws Exception {
        System.out.println("开始更新...");
        userService.updateUser(user);;
        return ResultUtil.success();
    }
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public Result<Object> delete(@RequestParam(value = "id", required = true) int userId) throws Exception {
        System.out.println("开始删除...");
        userService.deleteUser(userId);
        return ResultUtil.success();
    }
    
    @RequestMapping(value = "/userName", method = RequestMethod.GET)
    public Result<Object> findByUserName(@RequestParam(value = "name", required = true) String userName) {
        System.out.println("开始查询...");
        return ResultUtil.success(userService.findUserByName(userName));
    }
    
    @RequestMapping(value = "/userId", method = RequestMethod.GET)
    public Result<Object> findByUserId(@RequestParam(value = "id", required = true) int userId) {
        System.out.println("开始查询...");
        return ResultUtil.success(userService.findUserById(userId));
    }
    
    @RequestMapping(value = "/userAge", method = RequestMethod.GET)
    public Result<Object> findByUserAge(@RequestParam(value = "age", required = true) int userAge) {
        System.out.println("开始查询...");
        return ResultUtil.success(userService.findUserByAge(userAge));
    }

}
