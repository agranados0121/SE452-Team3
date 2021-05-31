package team5.ourstore.Ordering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shippingInfo")
public class ShippingInfoController {

    @Autowired
    private ShippingInfoRepository shippingRepository;

    @PostMapping
    public ShippingInfo addShippingInfo(ShippingInfo shippingInfo) {
        return shippingRepository.save(shippingInfo);
    }

    @GetMapping("/all")
    public List<ShippingInfo> getAll() {
        return shippingRepository.findAll();
    }
}