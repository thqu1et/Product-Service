package kz.thquiet.productservice.controller;

import kz.thquiet.productservice.dto.CategoryDto;
import kz.thquiet.productservice.dto.CategoryToCreateDto;
import kz.thquiet.productservice.service.CategoryService;
import kz.thquiet.productservice.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constant.API_ENDPOINT+Constant.CATEGORY_ENDPOINT , produces = "application/json")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService service;

    @SneakyThrows
    @PostMapping("/add")
    public ResponseEntity<CategoryDto> add(@RequestBody CategoryToCreateDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }

    @SneakyThrows
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDto> get(@PathVariable Integer id) {
        CategoryDto dto = service.get(id);
        return ResponseEntity.ok(dto);
    }

    @SneakyThrows
    @PatchMapping("/update/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Integer id, @RequestBody CategoryToCreateDto dto) {
        service.updateById(id, dto);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryDto> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @GetMapping("/list")
    public ResponseEntity<List<CategoryDto>> getList() {
        return ResponseEntity.ok(service.getList());
    }
}
