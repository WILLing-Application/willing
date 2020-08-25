package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findAllByOrderByIdDesc();
    List<Album> findAlbumsByUsersId(long id);
}


