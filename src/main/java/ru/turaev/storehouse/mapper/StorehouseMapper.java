package ru.turaev.storehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.turaev.storehouse.dto.StorehouseDto;
import ru.turaev.storehouse.model.Storehouse;

@Mapper(componentModel = "spring")
public interface StorehouseMapper {
    @Mapping(target = "working", expression = "java(true)")
    Storehouse fromDto(StorehouseDto storehouseDto);
}
