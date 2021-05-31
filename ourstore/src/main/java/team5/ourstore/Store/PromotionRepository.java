package team5.ourstore.Store;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PromotionRepository extends CrudRepository<Promotion,Integer> {
    
    List<Promotion> findAll();

}
