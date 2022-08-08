package ru.turaev.storehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.turaev.storehouse.dto.StorehouseDto;
import ru.turaev.storehouse.exception.StorehouseNotFoundException;
import ru.turaev.storehouse.mapper.StorehouseMapper;
import ru.turaev.storehouse.model.Storehouse;
import ru.turaev.storehouse.repository.StorehouseRepository;
import ru.turaev.storehouse.service.StorehouseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorehouseServiceImpl implements StorehouseService {
    private final StorehouseRepository repository;
    private final StorehouseMapper storehouseMapper;

    @Override
    public Storehouse getStorehouseById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StorehouseNotFoundException("Storehouse with id " + id + " not found"));
    }

    @Override
    public List<Storehouse> getAllStorehouses() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Storehouse save(StorehouseDto storehouseDto) {
        return repository.save(storehouseMapper.fromDto(storehouseDto));
    }

    @Override
    @Transactional
    public Storehouse updateStorehouse(long id, StorehouseDto storehouseDto) {
        Storehouse storehouse = getStorehouseById(id);
        storehouse.setName(storehouseDto.getName());
        storehouse.setAddressId(storehouseDto.getAddressId());
        return storehouse;
    }

    @Override
    @Transactional
    public Storehouse delete(long id) {
        Storehouse storehouse = getStorehouseById(id);
        storehouse.setWorking(false);
        return storehouse;
    }
}
