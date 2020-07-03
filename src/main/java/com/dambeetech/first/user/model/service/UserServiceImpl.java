package com.dambeetech.first.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambeetech.first.user.model.dao.UserDao;
import com.dambeetech.first.user.model.vo.User;

@Service("userService")
public class UserServiceImpl implements UserService{

		@Autowired
		private UserDao userDao;

		@Override
		public int selectUser() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public User login(User vo) {
			return userDao.login(vo);
		}
		@Override
		public int enroll(User vo) {
			return userDao.enroll(vo);
		}

	
}
