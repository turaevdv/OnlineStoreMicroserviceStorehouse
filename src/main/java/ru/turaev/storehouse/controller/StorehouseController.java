package ru.turaev.storehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.turaev.storehouse.dto.StorehouseDto;
import ru.turaev.storehouse.model.Storehouse;
import ru.turaev.storehouse.service.StorehouseService;

import java.util.List;

@RestController
@RequestMapping("api/v1/storehouses")
@RequiredArgsConstructor
public class StorehouseController {
    private final StorehouseService storehouseService;

    @GetMapping("/{id}")
    public Storehouse getStorehouseById(@PathVariable long id) {
        return storehouseService.getStorehouseById(id);
    }

    @GetMapping
    public List<Storehouse> getAllStorehouses() {
        return storehouseService.getAllStorehouses();
    }

    @PostMapping
    public Storehouse save(@RequestBody StorehouseDto storehouseDto) {
        return storehouseService.save(storehouseDto);
    }

    @PutMapping("/{id}")
    public Storehouse update(@PathVariable long id, @RequestBody StorehouseDto storehouseDto) {
        return storehouseService.updateStorehouse(id, storehouseDto);
    }

    @DeleteMapping("/{id}")
    public Storehouse delete(@PathVariable long id) {
        return storehouseService.delete(id);
    }

    @GetMapping("/exist/{id}")
    public boolean isStorehouseExist(@PathVariable long id) {
        return storehouseService.isStorehouseExist(id);
    }
}
