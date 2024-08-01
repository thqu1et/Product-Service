package kz.thquiet.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Suppliers",schema = "public")
    public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,name = "name", unique = true)
    private String name;

    @Column(unique = true, nullable = false , name = "contact_email")
    private String contactEmail;

    @Column(unique = true, nullable = false , name = "contact_phone")
    private String contactPhone;

    @Column(name = "create_at")
    private LocalDate createAt;

    @OneToMany(mappedBy = "supplier")
    private List<ProductEntity> products;
}
