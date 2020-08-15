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
import sbspj.security.model.User;
import sbspj.security.repository.UserRepository;
/**
 * 
 * @author Xiong
 *
 * 2020-8-6
 */

@Service(value = "userService")
@Transactional
@Resource(name="userRepo")
public class UserService {
	@Autowired 
	private UserRepository userRepo;
	@Autowired
	private VocabRepopsitory vocabRepo;
	
	@Transactional(readOnly = true)
	public Optional<User> getUserWithAuthorities(){

		return SecurityUtil.getCurrentUser().flatMap(userRepo::findOneWithAuthoritiesByUid);
		
	}
	
//	public ;
	
	public String vocabSet(Integer vid,String uid){
//		usr=SecurityUtil.getCurrentUser().get();
		User user=userRepo.findbyUid(uid);
//		vocab.setUsers; 
		VocabBean vocab=vocabRepo.findById(vid).get();
		if(vocab.isCollect()==true) {
			Set<VocabBean>temp=new HashSet<VocabBean>();
			temp.add(vocab);
			user.setVocabulary(temp);
			return "收藏成功";
		}else {
			return "收藏失败";
		}
		
	}
	public Optional<User> vocabCollections(String uid){
	Optional<User> vi=userRepo.findOneWithVocabByUid(uid);
		return vi;
	}
	
	public List<User> getAllUserList(){
		return userRepo.findAll();
	}
}
