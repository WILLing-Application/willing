package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {
}
