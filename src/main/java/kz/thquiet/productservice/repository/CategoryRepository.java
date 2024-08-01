package kz.thquiet.productservice.repository;

import kz.thquiet.productservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
