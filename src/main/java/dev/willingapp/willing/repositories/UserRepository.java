package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
