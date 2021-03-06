package sbspj.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
	
	private TokenProvider tokenProvider;
	
	public JWTConfigurer(TokenProvider tokenProvider) {
		// TODO Auto-generated constructor stub
		this.tokenProvider=tokenProvider;
	}

	@Override
	public void configure(HttpSecurity builder) throws Exception {
		// TODO Auto-generated method stub
		JWTFilter customFilter = new JWTFilter(tokenProvider);
        builder.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
