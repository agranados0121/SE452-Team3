package team5.ourstore.Stock;

import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long>{
    
    Inventory findByProductid(long id);
}
