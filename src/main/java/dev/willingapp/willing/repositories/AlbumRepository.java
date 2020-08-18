package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}


