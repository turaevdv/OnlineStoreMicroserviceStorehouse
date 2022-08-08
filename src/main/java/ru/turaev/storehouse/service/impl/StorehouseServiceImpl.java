package ru.turaev.storehouse.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.turaev.storehouse.dto.StorehouseDto;
import ru.turaev.storehouse.exception.StorehouseNotFoundException;
import ru.turaev.storehouse.mapper.StorehouseMapper;
import ru.turaev.storehouse.model.Storehouse;
import ru.turaev.storehouse.repository.StorehouseRepository;
import ru.turaev.storehouse.service.StorehouseService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StorehouseServiceImpl implements StorehouseService {
    private final StorehouseRepository repository;
    private final StorehouseMapper storehouseMapper;

    @Override
    public Storehouse getStorehouseById(long id) {
        log.info("Trying to find storehouse with id = {}", id);
        Storehouse storehouse = repository.findById(id)
                .orElseThrow(() -> new StorehouseNotFoundException("Storehouse with id " + id + " not found"));
        log.info("The storehouse with id = {} was found", id);
        return storehouse;
    }

    @Override
    public List<Storehouse> getAllStorehouses() {
        log.info("Trying to find all storehouses");
        return repository.findAll();
    }

    @Override
    @Transactional
    public Storehouse save(StorehouseDto storehouseDto) {
        log.info("Trying to save a new storehouse");
        Storehouse storehouse = repository.save(storehouseMapper.fromDto(storehouseDto));
        log.info("The storehouse was saved with id = {}", storehouse.getId());
        return storehouse;
    }

    @Override
    @Transactional
    public Storehouse updateStorehouse(long id, StorehouseDto storehouseDto) {
        log.info("Trying to update a storehouse with id = {}", id);
        Storehouse storehouse = getStorehouseById(id);
        storehouse.setName(storehouseDto.getName());
        storehouse.setAddressId(storehouseDto.getAddressId());
        log.info("The storehouse with id = {} successfully updated", id);
        return storehouse;
    }

    @Override
    @Transactional
    public Storehouse delete(long id) {
        log.info("Trying to delete a storehouse with id = {}", id);
        Storehouse storehouse = getStorehouseById(id);
        storehouse.setWorking(false);
        log.info("The storehouse with id = {} successfully deleted", id);
        return storehouse;
    }
}
