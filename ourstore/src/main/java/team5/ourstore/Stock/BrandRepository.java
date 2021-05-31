package team5.ourstore.Stock;

import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Brand findById(int i);
}
