package team5.ourstore.Stock;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
    Category findById(int i);
}
