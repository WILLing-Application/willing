package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
