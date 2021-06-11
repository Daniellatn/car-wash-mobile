package br.com.carwash.aplicacao.token;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import br.com.carwash.dto.UsuarioAutenticado;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTtoken {
	static String key ="bq9BjNI0AWv3mWKjoc+5+ahfxzV51o"
			+ "7eCEha51IFSso6SHvHaYpv97dI7PArdAvWwdBYx"
			+ "Fk0/r7OVMxO0rW/xTwq4zVPFdS/Ntni9x8kaWd9"
			+ "PzxsnpIyietS2L66esKCbVSXy4qRBz+h+gRnl+g"
			+ "THhqw+KsyoaR1PWxpjtchnls";

	static String audience ="mobil-app";
	
	public static String getStringTocken(UsuarioAutenticado user) {
		Instant now = Instant.now();
		byte[] segredo = Base64.getDecoder().decode(key);
		return Jwts.builder()
		.setSubject("mobil-token")
		.setAudience(audience)
		.setIssuedAt(Date.from(now))
		.claim("token-id",user.getUserId())
		.setExpiration(Date.from(now.plus(15,ChronoUnit.MINUTES)))
		.signWith(Keys.hmacShaKeyFor(segredo))
		.compact();
		
	}
	
	public static Jws<Claims> getClaim(String jwt) {
		byte[] segredo = Base64.getDecoder().decode(key);
		return Jwts.parser()
				.requireAudience(audience)
				.setAllowedClockSkewSeconds(60)
				.setSigningKey(Keys.hmacShaKeyFor(segredo))
				.parseClaimsJws(jwt);
	}
	
}
