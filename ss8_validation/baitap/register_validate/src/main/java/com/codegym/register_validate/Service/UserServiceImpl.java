package com.codegym.register_validate.Service;

import com.codegym.register_validate.Entity.User;
import com.codegym.register_validate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> getList() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(c -> users.add(c));
		return users;
	}

	@Override
	public void create(User user) {
		userRepository.save(user);
	}
}
