package kz.thquiet.productservice.dto;

import lombok.Data;

@Data
public class SupplierToCreateDto {
    private String name;
    private String contactEmail;
    private String contactPhone;
}
