package team5.ourstore.Ordering;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShippingInfoRepository extends MongoRepository<ShippingInfo, String> {

}