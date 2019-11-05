package pl.edu.wat.ai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.ai.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
