package kz.thquiet.productservice.repository;

import kz.thquiet.productservice.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    Optional<Supplier> findByContactEmail(String email);
    Optional<Supplier> findByContactPhone(String phone);
    @Query(value = "select * from Suppliers where name = :name",
    nativeQuery = true)
    Supplier findByIdIfName(@Param("name") String name);
}
