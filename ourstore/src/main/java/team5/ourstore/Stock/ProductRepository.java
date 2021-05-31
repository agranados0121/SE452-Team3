package team5.ourstore.Stock;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{

    Product findByProductid(Long id);
    Product findProductByCategoryid(Long id);
    List<Product> findAll();
    List<Product> getAllByCategoryid(long id);

}
