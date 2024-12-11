package dev.pravallika.product.repository;

import dev.pravallika.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
 Category findByName(String category);
 Category save(Category category);
 Optional<Category> findById(long id);
}
