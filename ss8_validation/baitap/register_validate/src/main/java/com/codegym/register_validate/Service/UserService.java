package com.codegym.register_validate.Service;

import com.codegym.register_validate.Entity.User;

import java.util.List;

public interface UserService {
	List<User> getList();
	void create(User user);
}
