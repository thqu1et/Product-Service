package kz.thquiet.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kz.thquiet.productservice.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
