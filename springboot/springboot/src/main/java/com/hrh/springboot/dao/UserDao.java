package com.hrh.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import com.hrh.springboot.entity.User;

@Mapper
public interface UserDao {

	/**
     * 用户数据新增
     */
     int addUser(User user); 
     
     /**
      * 用户数据修改
      */
     @Update("update user set name=#{name},age=#{age} where id=#{id}")
     int updateUser(User user);

     /**
      * 用户数据删除
     */
     @Delete("delete from user where id=#{id}")
     int deleteUser(int id);
    
      /**
     * 根据用户名称查询用户信息
     *
     */
    @Select("SELECT id,name,age FROM user where name=#{userName}")
    List<User> findByName(@Param("userName") String userName);
   
    /**
     * 根据用户ID查询用户信息
     *
     */
    @Select("SELECT id,name,age FROM user where id=#{userId}")     
    User findById(@Param("userId") int userId);
    
    
    /**
     * 根据用户age查询用户信息
     */
    @Select("SELECT id,name,age FROM user where age = #{userAge}")     
    List<User> findByAge(@Param("userAge") int userAge);
}
