package com.dambeetech.first.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dambeetech.first.user.model.vo.User;

@Repository("userDao")
public class UserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public User login(User vo) {
		
		return sqlSession.selectOne("userMapper.login", vo);
	}

	public int enroll(User vo) {
		return sqlSession.insert("userMapper.enroll", vo);
	}
}
