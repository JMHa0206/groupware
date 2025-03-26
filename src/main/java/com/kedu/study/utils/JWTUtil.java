package com.kedu.study.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;

@Component
public class JWTUtil {
	
	private String secret = "qwer";
	
	
	public String createToken(String loginID) {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		// util date 로 import
		Date now = new Date();
		Date expiresAt = new Date(now.getTime() + 86400000); // 86400000는 24시간에 해당.

		return JWT.create().withSubject(loginID).withIssuedAt(now).withExpiresAt(expiresAt).sign(algorithm);
	}
	
	
	public boolean validation (String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).build();
			verifier.verify(token); // 토큰을 가지고 검증을 하는 코드 예외 생기면 예외를 던진다.
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
}
