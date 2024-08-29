package andrevsc.java_spring_security_jwt.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import andrevsc.java_spring_security_jwt.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT e FROM User e WHERE e.username = (:username)")
    public User findByUsername(@Param ("username") String username);

    boolean existsByUsername(String username);
}