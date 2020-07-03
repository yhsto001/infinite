package com.dambeetech.first.user.model.service;

import com.dambeetech.first.user.model.vo.User;

public interface UserService {
int selectUser();

User login(User vo);

int enroll(User vo);
}
