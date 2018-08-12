package com.userfront.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.dao.UserDao;
import com.userfront.domain.User;
import com.userfront.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public User findByUserName(String username) {
		return userDao.findByUsername(username);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public boolean checkUserExists(String username,String email) {
		if(checkUsernameExists(username)||checkEmailExists(email)){
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean checkUsernameExists(String username) {
		if(null!=findByUserName(username)) {
			return true;
		}
		return false;
	}

	public boolean checkEmailExists(String email) {
		if(null!=findByEmail(email)) {
			return true;
		}
		return false;
	}

	
}
