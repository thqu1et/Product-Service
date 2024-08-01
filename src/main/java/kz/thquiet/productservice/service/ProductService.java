package kz.thquiet.productservice.service;

import kz.thquiet.productservice.dto.ProductDto;
import kz.thquiet.productservice.dto.ProductToCreateDto;

import java.util.List;

public interface ProductService {
    public ProductDto add(ProductToCreateDto dto);
    public ProductDto get(Integer id);
    public ProductDto updateById(Integer id, ProductToCreateDto dto);
    public void deleteById(Integer id);
    public List<ProductDto> getList();
}
