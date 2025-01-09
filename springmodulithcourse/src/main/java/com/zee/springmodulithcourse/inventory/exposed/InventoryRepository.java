package com.zee.springmodulithcourse.inventory.exposed;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zee.springmodulithcourse.inventory.Inventory;

@Repository
interface InventoryRepository extends CrudRepository<Inventory, Long> {

	Optional<Inventory> getInventoryByName(String name);
	List<Inventory> getInventoryByNameIn(Collection<String> name);
}
