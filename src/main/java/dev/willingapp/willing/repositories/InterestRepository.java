package dev.willingapp.willing.repositories;

import dev.willingapp.willing.models.Interest;
import dev.willingapp.willing.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    List<Interest> findInterestByItemId(Long item_id);
    List<Interest> findInterestByItem(Item item);
    List<Interest> findAll();
}
