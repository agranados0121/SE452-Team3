package team5.ourstore.Ordering;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Integer> {

    ShoppingCart findByCartid(int cartid);
}