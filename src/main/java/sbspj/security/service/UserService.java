package sbspj.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbspj.bean.VocabBean;
import sbspj.repository.VocabRepopsitory;
import sbspj.security.SecurityUtil;
import sbspj.security.model.Authorities;
import sbspj.security.model.User;
import sbspj.security.repository.AuthorityRepository;
import sbspj.security.repository.UserRepository;

/**
 * 
 * @author Xiong
 *
 *         2020-8-6
 */

@Service(value = "userService")
@Transactional
@Resource(name = "userRepo")
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private VocabRepopsitory vocabRepo;
	@Autowired
	private AuthorityRepository authorRepo;

	@Transactional(readOnly = true)
	public Optional<User> getUserWithAuthorities() {

		return SecurityUtil.getCurrentUser().flatMap(userRepo::findOneWithAuthoritiesByUid);

	}

	/*
	 * public String signUp(Integer id, String uid, String upwd, String name, String
	 * email, String address, String phone, Boolean actived, Integer aid) { User
	 * user = new User(); Optional<Authorities> ua = authorRepo.findById(aid);
	 * Authorities authorities = ua.get(); Set<Authorities> temp = new
	 * HashSet<Authorities>(); temp.add(authorities); user.setAuthority(temp);
	 * user.setId(id); user.setUid(uid); user.setUpwd(upwd); user.setName(name);
	 * user.setEmail(email); user.setActivated(actived); user.setAddress(address);
	 * user.setPhone(phone); userRepo.save(user); return "done"; }
	 */

	public String vocabSet(Integer vid, String uid) {
//		usr=SecurityUtil.getCurrentUser().get();
		User user = userRepo.findbyUid(uid);
//		vocab.setUsers; 
		VocabBean vocab = vocabRepo.findById(vid).get();
		if (vocab.isCollect() == true) {
			Set<VocabBean> temp = new HashSet<VocabBean>();
			temp.add(vocab);
			user.setVocabulary(temp);
			// userRepo.save(user);
			return "收藏成功";
		} else {
			return "收藏失败";
		}

	}

	public Optional<User> vocabCollections(String uid) {
		Optional<User> vi = userRepo.findOneWithVocabByUid(uid);
		return vi;
	}

	public List<User> getAllUserList() {
		return userRepo.findAll();
	}
	
	public Boolean checkReputationByid(Integer id){
		User user=userRepo.findById(id).get();
		if(user!=null) return true;
		else return false;
	}
	public Boolean  checkReputationByUid(String uid) {
		User user=userRepo.findbyUid(uid);
		if(user!=null) return true;
		else return false;
		
	}
	public String add(User user) {
		// TODO Auto-generated method stub
		/*
		 * Integer id = user.getId(); String uid = user.getUid(); if
		 * (userRepo.findById(id) == null && userRepo.findbyUid(uid) == null) { return
		 * userRepo.save(user) == null ? "Failure" : "Success"; } else if
		 * (userRepo.findById(id) != null) { return "id already exists"; } else return
		 * "username already exists";
		 */

		return userRepo.save(user)==null?"Failure":"Success";
	}

}
