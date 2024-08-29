package andrevsc.java_spring_security_jwt.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
    public static String PREFIX;
    public static String KEY;
    public static long EXPIRATION;
    public void setPrefix(String prefix) {
        PREFIX = prefix;
    }

    public static void setKEY(String kEY) {
        KEY = kEY;
    }

    public static void setEXPIRATION_TIME(long expiration) {
        EXPIRATION = expiration;
    }
}
