package sbspj.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JWTFilter extends GenericFilterBean {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(JWTFilter.class);

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private TokenProvider tokenProvider;

	public JWTFilter(TokenProvider tokenProvider) {
		// TODO Auto-generated constructor stub
		this.tokenProvider = tokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String jwt = resolveToken(httpServletRequest);
		String requestURI = httpServletRequest.getRequestURI();

		if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
			Authentication authentication = tokenProvider.getAuthentication(jwt);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			LOG.debug("set Authentication to security context for '{}', uri: {}", authentication.getName(), requestURI);
		} else {
			LOG.debug("no valid JWT token found, uri: {}", requestURI);
		}

		chain.doFilter(request, response);
	}

	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring(7);
		}
		return null;

	}

}
