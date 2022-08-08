package ru.turaev.storehouse.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StorehouseDto {
    private final String name;
    private final int addressId;
}
