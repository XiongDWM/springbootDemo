package sbspj.security;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sbspj.security.model.User;
import sbspj.security.repository.UserRepository;


@Component("userDetailsService")
@AllArgsConstructor
@NoArgsConstructor
public class AdministrateUserDetailsService implements UserDetailsService {

	
	private final Logger log=LoggerFactory.getLogger(AdministrateUserDetailsService.class);
	@Autowired 
	private UserRepository userRepo;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login){
		log.debug("Authenticating user '{}'", login);

	      if (new EmailValidator().isValid(login, null)) {
	         return userRepo.findOneWithAuthoritiesByEmailIgnoreCase(login)
	            .map(user -> createSpringSecurityUser(login, user))
	            .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
	      }

	      String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
	      return userRepo.findOneWithAuthoritiesByUid(lowercaseLogin)
	         .map(user -> createSpringSecurityUser(lowercaseLogin, user))
	         .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));

	   }

	   private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
	      if (!user.isActivated()) {
	         throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
	      }
	      List<GrantedAuthority> grantedAuthorities = user.getAuthority().stream()
	         .map(authority -> new SimpleGrantedAuthority(authority.getRoles()))
	         .collect(Collectors.toList());
	      return new org.springframework.security.core.userdetails.User(user.getUid(), 
	    		  user.getUpwd(), 
	    		  	grantedAuthorities);
	}

}
