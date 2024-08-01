package kz.thquiet.productservice.controller;

import kz.thquiet.productservice.dto.FindByNameDto;
import kz.thquiet.productservice.dto.SupplierDto;
import kz.thquiet.productservice.dto.SupplierToCreateDto;
import kz.thquiet.productservice.service.SupplierService;
import kz.thquiet.productservice.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constant.API_ENDPOINT+Constant.SUPPLIER_ENDPOINT , produces = "application/json")
@RequiredArgsConstructor
@Slf4j
public class SupplierController {

    private final SupplierService service;

    @SneakyThrows
    @PostMapping("/add")
    public ResponseEntity<SupplierDto> add(@RequestBody SupplierToCreateDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }

    @SneakyThrows
    @GetMapping("/get/{id}")
    public ResponseEntity<SupplierDto> get(@PathVariable Integer id) {
        SupplierDto dto = service.get(id);
        return ResponseEntity.ok(dto);
    }

    @SneakyThrows
    @PatchMapping("/update/{id}")
    public ResponseEntity<SupplierDto> update(@PathVariable Integer id, @RequestBody SupplierToCreateDto dto) {
        service.updateById(id, dto);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SupplierDto> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @GetMapping("/list")
    public ResponseEntity<List<SupplierDto>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @SneakyThrows
    @GetMapping("/find-by-name")
    public ResponseEntity<SupplierDto> findbyname(@RequestBody FindByNameDto nameDto) {
        SupplierDto dto = service.findByName(nameDto.getName());
        return ResponseEntity.ok(dto);
    }
}
