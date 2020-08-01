package sbspj.security.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbspj.security.SecurityUtil;
import sbspj.security.model.User;
import sbspj.security.repository.UserRepository;


@Service(value = "userService")
@Transactional
@Resource(name="userRepo")
public class UserService {
	@Autowired 
	private UserRepository userRepo;
	
	@Transactional(readOnly = true)
	public Optional<User> getStudentWithAuthorities(){
		//TODO after build SercurityUtil todo: SecurityUtils.getCurrentStudnt().flatMap(studentRepository::findOneWithAuthoritiesByStudnt);
		
		return SecurityUtil.getCurrentStudnt().flatMap(userRepo::findOneWithAuthoritiesByUid);
		
	}
}
