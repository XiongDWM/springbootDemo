package sbspj.security;

import org.springframework.security.core.AuthenticationException;

public class UserNotActivatedException extends AuthenticationException {

	public UserNotActivatedException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
