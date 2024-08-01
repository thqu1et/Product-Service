package kz.thquiet.productservice.controller;

import kz.thquiet.productservice.dto.CategoryDto;
import kz.thquiet.productservice.dto.CategoryToCreateDto;
import kz.thquiet.productservice.dto.ProductDto;
import kz.thquiet.productservice.dto.ProductToCreateDto;
import kz.thquiet.productservice.service.ProductService;
import kz.thquiet.productservice.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constant.API_ENDPOINT+Constant.PRODUCT_ENDPOINT , produces = "application/json")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    @SneakyThrows
    @PostMapping("/add")
    public ResponseEntity<ProductDto> add(@RequestBody ProductToCreateDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }

    @SneakyThrows
    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Integer id) {
        ProductDto dto = service.get(id);
        return ResponseEntity.ok(dto);
    }

    @SneakyThrows
    @PatchMapping("/update/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Integer id, @RequestBody ProductToCreateDto dto) {
        service.updateById(id, dto);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductDto> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getList() {
        return ResponseEntity.ok(service.getList());
    }
}
