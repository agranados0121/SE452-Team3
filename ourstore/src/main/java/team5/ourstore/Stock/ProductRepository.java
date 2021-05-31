package team5.ourstore.Stock;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{

    Product findByProductid(Long id);
    List<Product> findAll();

}
