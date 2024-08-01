package kz.thquiet.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products",schema = "public")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "description" , nullable = false)
    private String description;

    @Column(name = "price" , nullable = false)
    private double price;

    @Column(name = "quantity" , nullable = false)
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}