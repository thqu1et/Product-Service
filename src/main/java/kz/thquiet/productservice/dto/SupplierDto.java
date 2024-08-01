package kz.thquiet.productservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SupplierDto {
    private Integer id;
    private String name;
    private String contactEmail;
    private String contactPhone;
    private LocalDate createdAt;
}
