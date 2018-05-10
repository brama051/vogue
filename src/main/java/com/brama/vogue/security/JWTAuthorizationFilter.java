package com.brama.vogue.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

/**
 * The Class JWTAuthorizationFilter.
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(JWTAuthorizationFilter.class);

	/** The Constant TOKEN_PREFIX. */
	public static final String TOKEN_PREFIX = "Bearer ";

	/** The Constant AUTHORIZATION_HEADER. */
	public static final String AUTHORIZATION_HEADER = "Authorization";

	/**
	 * Instantiates a new JWT authorization filter.
	 *
	 * @param authManager
	 *            the auth manager
	 */
	public JWTAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.www.BasicAuthenticationFilter
	 * #doFilterInternal(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(AUTHORIZATION_HEADER);

		if (header == null || !header.startsWith(TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

	/**
	 * Gets the authentication.
	 *
	 * @param request
	 *            the request
	 * @return the authentication
	 */
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(AUTHORIZATION_HEADER);
		if (token != null) {
			// parse the token.
			CertificateFactory fact = null;
			PublicKey key = null;
			try {
				fact = CertificateFactory.getInstance("X.509");
				ClassPathResource classPathResource = new ClassPathResource("hearthum.pem");
				InputStream is = classPathResource.getInputStream();
				X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
				key = cer.getPublicKey();
			} catch (CertificateException | IOException e) {
				logger.error(e.getMessage());
			}

			String user = Jwts.parser().setSigningKey(key).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
					.getSubject();

			if (user != null) {
				logger.info(
						"Token owner, identified by '" + user + "' has successfully claimed client credentials grant");
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			}
			return null;
		}
		return null;
	}
}
