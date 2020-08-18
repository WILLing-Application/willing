package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
