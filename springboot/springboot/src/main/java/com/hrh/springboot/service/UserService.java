package com.hrh.springboot.service;

import java.util.List;

import com.hrh.springboot.entity.User;

public interface UserService {

	/**
     * 新增用户
     * @param user
     * @return
	 * @throws Exception 
     */
    void addUser(User user) throws Exception;
    
    /**
     * 修改用户
     * @param user
     * @return
     */
    void updateUser(User user) throws Exception;
    
    
    /**
     * 删除用户
     * @param id
     * @return
     */
    void deleteUser(int id) throws Exception;
    
     /**
     * 根据用户名字查询用户信息
     * @param userName
     */
    List<User> findUserByName(String userName);
    
    /**
     * 根据用户ID查询用户信息
     * @param userId
     */
    User findUserById(int userId);
    
     /**
     * 根据用户ID查询用户信息
     * @param userAge
     */
    List<User> findUserByAge(int userAge);
}
