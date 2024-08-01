package kz.thquiet.productservice.service.impl;

import kz.thquiet.productservice.dto.SupplierDto;
import kz.thquiet.productservice.dto.SupplierToCreateDto;
import kz.thquiet.productservice.entity.Supplier;
import kz.thquiet.productservice.exception.EmptyValueException;
import kz.thquiet.productservice.exception.NotFoundException;
import kz.thquiet.productservice.repository.SupplierRepository;
import kz.thquiet.productservice.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    @Override
    public SupplierDto add(SupplierToCreateDto dto) {
        Supplier supplier = new Supplier();
        if (dto.getName().equals("") || dto.getName() == null){
            throw new EmptyValueException("Supplier name is not null or empty!");
        }
        supplier.setName(dto.getName());

        if (dto.getContactEmail().equals("") || dto.getContactEmail() == null){
            throw new EmptyValueException("Supplier contact email is not null or empty!");
        }
        supplier.setContactEmail(dto.getContactEmail());

        if (dto.getContactPhone().equals("") || dto.getContactPhone() == null){
            throw new EmptyValueException("Supplier contact phone is not null or empty!");
        }
        supplier.setContactPhone(dto.getContactPhone());
        supplier.setCreateAt(LocalDate.now());
        repository.save(supplier);
        return convert(supplier);
    }

    @Override
    public SupplierDto get(Integer id) {
        Optional<Supplier> supplier = repository.findById(id);
        if (!supplier.isPresent()){
            throw new NotFoundException("Supplier not found!");
        }
        return convert(supplier.get());
    }

    @Override
    public SupplierDto updateById(Integer id, SupplierToCreateDto dto) {
        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier not found!"));
        if (dto.getName().equals("") || dto.getName() == null){
            throw new EmptyValueException("Supplier name is not null or empty!");
        }
        supplier.setName(dto.getName());

        if (dto.getContactEmail().equals("") || dto.getContactEmail() == null){
            throw new EmptyValueException("Supplier contact email is not null or empty!");
        }
        supplier.setContactEmail(dto.getContactEmail());

        if (dto.getContactPhone().equals("") || dto.getContactPhone() == null){
            throw new EmptyValueException("Supplier contact phone is not null or empty!");
        }
        supplier.setContactPhone(dto.getContactPhone());
        repository.save(supplier);
        return convert(supplier);
    }

    @Override
    public void deleteById(Integer id) {
        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Supplier not found!"));
        repository.delete(supplier);
    }

    @Override
    public List<SupplierDto> getList() {
        return repository.findAll()
                .stream().sorted(Comparator.comparing(Supplier::getId))
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDto findByName(String name) {
        Supplier supplier = repository.findByIdIfName(name);
        if (supplier == null){
            throw new EmptyValueException("Supplier is empty or null!");
        }
        return convert(supplier);
    }

    private SupplierDto convert(Supplier supplier) {
        return SupplierDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .contactEmail(supplier.getContactEmail())
                .contactPhone(supplier.getContactPhone())
                .createdAt(supplier.getCreateAt())
                .build();
    }
}
