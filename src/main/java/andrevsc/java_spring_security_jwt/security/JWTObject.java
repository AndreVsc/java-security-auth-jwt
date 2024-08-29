package andrevsc.java_spring_security_jwt.security;

import java.util.Date;
import java.util.List;
import java.util.Arrays;

public class JWTObject {
    private String subject;
    private Date issuedAt;
    private Date expiration;
    private List<String> roles;

    public JWTObject() {
    }

    public JWTObject(String subject, Date issuedAt, Date expiration, List<String> roles) {
        this.subject = subject;
        this.issuedAt = issuedAt;
        this.expiration = expiration;
        this.roles = roles;
    }

    // Getters and Setters

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(String ... roles) {
        this.roles = Arrays.asList(roles);
    }

    @Override
    public String toString() {
        return "JWTObject{" +
                "subject='" + subject + '\'' +
                ", issuedAt=" + issuedAt +
                ", expiration=" + expiration +
                ", roles=" + roles +
                '}';
    }

}