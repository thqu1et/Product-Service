package kz.thquiet.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private double quantity;
    private Integer categoryId;
    private String categoryName;
    private Integer supplierId;
    private String supplierName;
}
