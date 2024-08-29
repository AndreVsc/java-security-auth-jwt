package andrevsc.java_spring_security_jwt.security;

import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTFilterConfig {

    @Bean
    public SecretKey secretKey() {
        return Jwts.SIG.HS256.key().build();
    }

    @Bean
    public JWTFilter jwtFilter(SecretKey secretKey) {
        String prefix = "Bearer ";
        return new JWTFilter(secretKey, prefix);
    }
}