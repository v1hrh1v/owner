package com.hrh.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrh.springboot.dao.UserDao;
import com.hrh.springboot.entity.User;
import com.hrh.springboot.handle.UserException;
import com.hrh.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) throws Exception {
		try {
			userDao.addUser(user);
		} catch (Exception e){
			throw new Exception();
		}
	}

	@Override
	public void updateUser(User user) throws Exception{
		try{
			userDao.updateUser(user);
		} catch (Exception e){
			throw new Exception();
		}
	}

	@Override
	public void deleteUser(int id) throws Exception{
		try{
			userDao.deleteUser(id);
		} catch (Exception e){
			throw new Exception();
		}
	}

	@Override
	public List<User> findUserByName(String userName) {
		List<User> user = userDao.findByName(userName);
		checkAge(user);
		return user ;
	}

	@Override
	public User findUserById(int userId) {
		User user =  userDao.findById(userId);
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		checkAge(userList);
		return user ;
	}


	@Override
	public List<User> findUserByAge(int userAge) {
		List<User> user =  userDao.findByAge(userAge);
		checkAge(user);
		return user ;
	}

	private void checkAge(List<User> userList) {
		for (User user : userList){
			if (user != null && user.getAge() != null && user.getAge() <= 10){
				throw new UserException(1,user.getName() + "小于等于10岁");
			} else if (user != null && user.getAge() != null && user.getAge() > 10 && user.getAge() < 20) {
				throw new UserException(2,user.getName() + "大于10岁，小于等于20");
			}
		}
	}
}
