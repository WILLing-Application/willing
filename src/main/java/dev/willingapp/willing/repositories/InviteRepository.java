package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepository extends JpaRepository<Invite, Long> {
}
