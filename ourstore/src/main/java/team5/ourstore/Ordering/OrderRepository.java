package team5.ourstore.Ordering;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CustomerOrder, Integer> {
    
}
