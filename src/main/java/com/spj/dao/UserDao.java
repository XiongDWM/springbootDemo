package com.spj.dao;

import java.util.List;

import com.spj.model.User;

public interface UserDao {
	List<User> findAll();
	void add(User user);
	List<User> fussySearch();
}
