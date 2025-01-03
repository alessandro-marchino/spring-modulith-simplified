package com.zee.springmodulithcourse.inventory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {

	Optional<Inventory> getInventoryByName(String name);
	List<Inventory> getInventoryByNameIn(Collection<String> name);
}
