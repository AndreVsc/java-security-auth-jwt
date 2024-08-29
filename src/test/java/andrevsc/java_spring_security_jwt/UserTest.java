package andrevsc.java_spring_security_jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import andrevsc.java_spring_security_jwt.models.User;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("testUser", "testPassword", Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
    }

    @Test
    public void testUserConstructor() {
        assertNotNull(user);
        assertEquals("testUser", user.getUsername());
        assertEquals("testPassword", user.getPassword());
        assertEquals(Arrays.asList("ROLE_USER", "ROLE_ADMIN"), user.getRoles());
    }

    @Test
    public void testSetAndGetId() {
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    public void testSetAndGetUsername() {
        user.setUsername("newUser");
        assertEquals("newUser", user.getUsername());
    }

    @Test
    public void testSetAndGetPassword() {
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }

    @Test
    public void testSetAndGetRoles() {
        List<String> newRoles = Arrays.asList("ROLE_USER");
        user.setRoles(newRoles);
        assertEquals(newRoles, user.getRoles());
    }
}