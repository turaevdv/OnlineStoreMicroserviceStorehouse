package ru.turaev.storehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.turaev.storehouse.model.Storehouse;

@Repository
public interface StorehouseRepository extends JpaRepository<Storehouse, Long> {

}
