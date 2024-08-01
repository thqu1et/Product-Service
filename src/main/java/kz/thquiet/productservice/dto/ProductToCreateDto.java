package kz.thquiet.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductToCreateDto {
    private String name;
    private String description;
    private double price;
    private double quantity;
    private Integer categoryId;
    private Integer supplierId;
}
