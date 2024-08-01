package kz.thquiet.productservice.service.impl;

import kz.thquiet.productservice.dto.CategoryDto;
import kz.thquiet.productservice.dto.CategoryToCreateDto;
import kz.thquiet.productservice.entity.Category;
import kz.thquiet.productservice.entity.ProductEntity;
import kz.thquiet.productservice.exception.EmptyValueException;
import kz.thquiet.productservice.exception.NotFoundException;
import kz.thquiet.productservice.repository.CategoryRepository;
import kz.thquiet.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public CategoryDto add(CategoryToCreateDto dto) {
        Category category = new Category();
        if (dto.getName().equals("") || dto.getName() == null){
            throw new EmptyValueException("Category name is not null or empty!");
        }
        category.setName(dto.getName());
        repository.save(category);
        return convert(category);
    }

    @Override
    public CategoryDto get(Integer id) {
        Optional<Category> category = repository.findById(id);
        if (!category.isPresent()) {
            throw new EmptyValueException("Category is empty or not exist");
        }
        return convert(category.get());
    }

    @Override
    public CategoryDto updateById(Integer id, CategoryToCreateDto dto) {
        Category category = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Category not found")
        );
        category.setName(dto.getName());
        repository.save(category);
        return convert(category);
    }

    @Override
    public void deleteById(Integer id) {
        Category category = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Category not found")
        );
        repository.delete(category);
    }

    @Override
    public List<CategoryDto> getList() {
        return repository.findAll()
                .stream().sorted(Comparator.comparing(Category::getId))
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private CategoryDto convert(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
