package com.spj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spj.dao.UserDao;
import com.spj.model.User;
import com.spj.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	/*
	 * public String add(User user) { if (findUserByUsername(user.getUid())) { int
	 * text = userDao.add(user); return text == 0 ? "Fail" : "Success"; } return
	 * "Already Exist"; }
	 * 
	 * private boolean findUserByUsername(String uid) { // TODO Auto-generated
	 * method stub User user = userDao.searchByUsername(uid);
	 * 
	 * return user == null; }
	 * 
	 * public String login(User user) { if (!findByUidAndPwd(user)) { return "p"; }
	 * return "ERRRRRRR"; }
	 * 
	 * public Result findAll() { Result rs = new Result();
	 * rs.setObject(userDao.findAll()); return rs; }
	 * 
	 * private boolean findByUidAndPwd(User user) { // TODO Auto-generated method
	 * stub return userDao.searchByUidAndPwd(user) == null; }
	 * 
	 * 
	 * public Result del(int i) { // TODO Auto-generated method stub Result result =
	 * new Result(); result.setResult(userDao.del(i) == 1 ? "Success" : "Fail");
	 * return result; }
	 * 
	 * public List<User> getUser() { // TODO Auto-generated method stub return
	 * userDao.getUser(); }
	 * 
	 * public Result fussySearch(User user) { // TODO Auto-generated method stub
	 * Result rs = new Result(); rs.setObject(userDao.fussySearch(user)); return rs;
	 * }
	 */

}
