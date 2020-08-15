package sbspj.security;

import java.util.Optional;

import  org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SecurityUtil {
	private static final Logger LOG=LoggerFactory.getLogger(SecurityUtil.class);
	
	public static Optional<String> getCurrentUser(){
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null) {
			LOG.debug("no authentication in security context found");
			return Optional.empty();
		}
		String studnt=null;
		if (authentication.getPrincipal() instanceof UserDetails) {
	         UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
	         studnt= springSecurityUser.getUsername();
	      } else if (authentication.getPrincipal() instanceof String) {
	         studnt = (String) authentication.getPrincipal();
	      }

	      LOG.debug("found student '{}' in security context", studnt);

	      return Optional.ofNullable(studnt);
		
	}
}
