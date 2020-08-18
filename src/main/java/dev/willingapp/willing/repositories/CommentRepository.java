package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
