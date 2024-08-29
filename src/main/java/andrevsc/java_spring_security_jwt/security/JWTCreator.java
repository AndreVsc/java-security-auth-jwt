package andrevsc.java_spring_security_jwt.security;

import java.security.SignatureException;
import java.util.List;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;

public class JWTCreator {

    public static final String HEADER_AUTHORITIES = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    public static String create(String prefix, SecretKey key, JWTObject jwtObject) {
        return Jwts.builder()
                .subject(jwtObject.getSubject()) // Use 'setSubject'
                .claim(ROLES_AUTHORITIES, jwtObject.getRoles())
                .issuedAt(jwtObject.getIssuedAt()) // Use 'setIssuedAt'
                .expiration(jwtObject.getExpiration()) // Use 'setExpiration'
                .signWith(key) // Sign with key
                .compact();
    }

    public static JWTObject parse(String token, String prefix, SecretKey key) 
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        JWTObject object = new JWTObject();
        token = token.replace(prefix + " ", "");
        Claims claims = Jwts.parser()
                .verifyWith(key) // Set the signing key
                .build()
                .parseSignedClaims(token)
                .getPayload();

        object.setSubject(claims.getSubject());
        object.setIssuedAt(claims.getIssuedAt());
        object.setExpiration(claims.getExpiration());
        
        @SuppressWarnings("unchecked")
        List<String> roles = claims.get(ROLES_AUTHORITIES, List.class);
        object.setRoles(roles.toArray(new String[0])); // Convert List to String[]
        
        return object;
    }
}
