package kz.thquiet.productservice.service;

import kz.thquiet.productservice.dto.CategoryDto;
import kz.thquiet.productservice.dto.CategoryToCreateDto;

import java.util.List;

public interface CategoryService {
    public CategoryDto add(CategoryToCreateDto dto);
    public CategoryDto get(Integer id);
    public CategoryDto updateById(Integer id, CategoryToCreateDto dto);
    public void deleteById(Integer id);
    public List<CategoryDto> getList();
}
