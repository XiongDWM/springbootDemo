package sbspj.security;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import sbspj.security.model.Student;
import sbspj.security.repository.StudentRepository;


@Component("userDetailsService")
public class StudentDetailsService implements UserDetailsService {
	
	private final Logger log=LoggerFactory.getLogger(StudentDetailsService.class);
	private final StudentRepository studentRepository;
	public StudentDetailsService() {
		this.studentRepository = null;
		
	}
	public StudentDetailsService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	

	@Override
	public UserDetails loadUserByUsername(String login){
		log.debug("Authenticating user '{}'", login);

	      if (new EmailValidator().isValid(login, null)) {
	         return studentRepository.findOneWithAuthoritiesByEmailIgnoreCase(login)
	            .map(user -> createSpringSecurityUser(login, user))
	            .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
	      }

	      String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
	      return studentRepository.findOneWithAuthoritiesByStudnt(lowercaseLogin)
	         .map(user -> createSpringSecurityUser(lowercaseLogin, user))
	         .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));

	   }

	   private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, Student user) {
	      if (!user.isActivated()) {
	         throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
	      }
	      List<GrantedAuthority> grantedAuthorities = user.getAuthority().stream()
	         .map(authority -> new SimpleGrantedAuthority(authority.getRoles()))
	         .collect(Collectors.toList());
	      return new org.springframework.security.core.userdetails.User(user.getSid(),
	         user.getSpwd(),
	         grantedAuthorities);
	}

}
