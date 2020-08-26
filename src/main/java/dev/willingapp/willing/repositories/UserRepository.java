package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { // curriculum has repo name Users
    // Spring Security needs this to authenticate users
    User findByUsername(String username);
    User findByEmail(String email);
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
}
