package kz.thquiet.productservice.service.impl;

import kz.thquiet.productservice.dto.ProductDto;
import kz.thquiet.productservice.dto.ProductToCreateDto;
import kz.thquiet.productservice.entity.Category;
import kz.thquiet.productservice.entity.ProductEntity;
import kz.thquiet.productservice.entity.Supplier;
import kz.thquiet.productservice.exception.EmptyValueException;
import kz.thquiet.productservice.exception.NotFoundException;
import kz.thquiet.productservice.repository.CategoryRepository;
import kz.thquiet.productservice.repository.ProductRepository;
import kz.thquiet.productservice.repository.SupplierRepository;
import kz.thquiet.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDto add(ProductToCreateDto dto) {
        ProductEntity product = new ProductEntity();
        if (dto.getName().equals("") || dto.getName() == null){
            throw new EmptyValueException("Product name is not null or empty!");
        }
        product.setName(dto.getName());

        if (dto.getDescription().equals("") || dto.getDescription() == null){
            throw new EmptyValueException("Product description is not null or empty!");
        }
        product.setDescription(dto.getDescription());

        if (dto.getPrice() == 0){
            throw new EmptyValueException("Product description is not equal to zero!");
        }
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        categoryRepository.findById(dto.getCategoryId()).ifPresent(category -> {
            product.setCategory(category);
        });

        supplierRepository.findById(dto.getSupplierId()).ifPresent(supplier -> {
            product.setSupplier(supplier);
        });

        productRepository.save(product);
        return convert(product);
    }

    @Override
    public ProductDto get(Integer id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (!product.isPresent()){
            throw new NotFoundException("Product not found!");
        }
        return convert(product.get());
    }

    @Override
    public ProductDto updateById(Integer id, ProductToCreateDto dto) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found!"));
        if (dto.getName().equals("") || dto.getName() == null){
            throw new EmptyValueException("Product name is not null or empty!");
        }
        product.setName(dto.getName());

        if (dto.getDescription().equals("") || dto.getDescription() == null){
            throw new EmptyValueException("Product description is not null or empty!");
        }
        product.setDescription(dto.getDescription());

        if (dto.getPrice() == 0){
            throw new EmptyValueException("Product description is not equal to zero!");
        }
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        categoryRepository.findById(dto.getCategoryId()).ifPresent(category -> {
            product.setCategory(category);
        });

        supplierRepository.findById(dto.getSupplierId()).ifPresent(supplier -> {
            product.setSupplier(supplier);
        });

        productRepository.save(product);
        return convert(product);
    }

    @Override
    public void deleteById(Integer id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found!"));
        productRepository.delete(product);
    }

    @Override
    public List<ProductDto> getList() {
        return productRepository.findAll()
                .stream().sorted(Comparator.comparing(ProductEntity::getId))
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private ProductDto convert(ProductEntity entity) {
        Category cat = categoryRepository.findById(entity.getCategory().getId())
                .orElseThrow(()-> new NotFoundException("Category not found!"));
        Supplier supplier = supplierRepository.findById(entity.getSupplier().getId())
                .orElseThrow(()-> new NotFoundException("Supplier not found!"));
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .categoryId(cat.getId())
                .categoryName(cat.getName())
                .supplierId(supplier.getId())
                .supplierName(supplier.getName())
                .build();
    }
}
