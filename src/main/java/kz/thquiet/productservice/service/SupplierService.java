package kz.thquiet.productservice.service;

import kz.thquiet.productservice.dto.SupplierDto;
import kz.thquiet.productservice.dto.SupplierToCreateDto;

import java.util.List;

public interface SupplierService {
    public SupplierDto add(SupplierToCreateDto dto);
    public SupplierDto get(Integer id);
    public SupplierDto updateById(Integer id, SupplierToCreateDto dto);
    public void deleteById(Integer id);
    public List<SupplierDto> getList();
    public SupplierDto findByName(String name);
}
