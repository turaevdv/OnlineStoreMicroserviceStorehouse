package ru.turaev.storehouse.service;

import ru.turaev.storehouse.dto.StorehouseDto;
import ru.turaev.storehouse.model.Storehouse;

import java.util.List;

public interface StorehouseService {
    Storehouse getStorehouseById(long id);
    List<Storehouse> getAllStorehouses();
    Storehouse save(StorehouseDto storehouseDto);
    Storehouse updateStorehouse(long id, StorehouseDto storehouseDto);
    Storehouse delete(long id);
}
