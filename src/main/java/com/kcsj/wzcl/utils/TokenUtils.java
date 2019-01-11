package com.kcsj.wzcl.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * token工具类
 */
public class TokenUtils {

    private static final long duration = 60*100;
    private static final String BASE64 = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

    public static String createJwt(String issuer, String username, String role) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long time = System.currentTimeMillis() + duration;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(BASE64);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("tpy", "JWT")
                .setIssuer(issuer)
                .claim("username", username)
                .claim("role", role)
                .claim("expireTime", time)
                .signWith(signatureAlgorithm, signingKey);

        return jwtBuilder.compact();
    }

    /**
     * @param jsonWebToken
     * @return
     */
    public static Claims parseJWT(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(BASE64))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

    public static boolean checkJWT(String anth) {
        Claims claims = parseJWT(anth);

        return claims != null;
    }
    public static String getUser(String anth){
        Claims claims = parseJWT(anth);
        return (String)claims.get("usrename");
    }

}
