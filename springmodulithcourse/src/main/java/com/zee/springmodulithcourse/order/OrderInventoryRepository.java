package com.zee.springmodulithcourse.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInventoryRepository extends CrudRepository<OrderInventory, Long> {
	
	@Query("SELECT SUM(totalQuantityPrice) FROM OrderInventory WHERE orderId = :orderId")
	long orderIdAmount(long orderId);
}
