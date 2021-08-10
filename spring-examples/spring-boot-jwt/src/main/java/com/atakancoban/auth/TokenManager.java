package com.atakancoban.auth;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

@Service
public class TokenManager {
	// Token geçerlilik süresü
	private static final int validity = 5 * 60 * 1000;

	// şifreleme algoritması
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	// token oluşturma metodu
	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuer("atakancoban.com")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + validity)).signWith(key).compact();
	}

	// token geçerli mi
	public boolean tokenValidate(String token) {
		if (getUsernameToken(token) != null && isExpired(token)) {
			return true;
		}
		return false;
	}

//parçalanmış tokenın username kısmını dön
	public String getUsernameToken(String token) {
		Claims claims = getClaims(token);
		return claims.getSubject();
	}

//parçalanmış tokendan expire date bilgsini al
	public boolean isExpired(String token) {
		Claims claims = getClaims(token);
		return claims.getExpiration().after(new Date(System.currentTimeMillis()));
	}

//tokenın parçalanmış hali
	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	}

}
