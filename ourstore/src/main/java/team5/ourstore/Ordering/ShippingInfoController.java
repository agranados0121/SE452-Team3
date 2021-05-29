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

    public ShippingInfoController(ShippingInfoRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @PostMapping
    public ShippingInfo addShippingInfo(ShippingInfo shippingInfo) {
        return shippingRepository.save(shippingInfo);
    }

    @GetMapping("/all")
    public List<ShippingInfo> getAll() {
        return shippingRepository.findAll();
    }

    // Test data
    
    public List<ShippingInfo> setUpTestData() {
        List<ShippingInfo> shippingInfo = new ArrayList<>();
        shippingInfo.add(new ShippingInfo(1, "mr.", "chris", "7200 Bustleton Avenue", "Philadelphia", "PA", 19149));
        shippingInfo.add(new ShippingInfo(2, "ms.", "lucy", "6030 Torresdale Avenue", "Philadelphia", "PA", 19135));
        shippingInfo.add(new ShippingInfo(3, "mr.", "mortimer", "3653 Germantown Avenue", "Philadelphia", "PA", 19140));
        shippingInfo.add(new ShippingInfo(4, "ms.", "matilda", "600 Wendover Street8766789", "Philadelphia", "PA", 19128));
        shippingInfo.add(new ShippingInfo(5, "mr.", "matthew", "471 Leverington Avenue", "Philadelphia", "PA", 19128));
        shippingInfo.add(new ShippingInfo(6, "mr.", "gerald", "695 North Broad Street", "Philadelphia", "PA", 19123));
        shippingInfo.add(new ShippingInfo(7, "mr.", "bill", "614 North 2nd Street", "Philadelphia", "PA", 19123));
        shippingInfo.add(new ShippingInfo(8, "ms.", "madelyn", "228 Market Street", "Philadelphia", "PA", 19106));
        shippingInfo.add(new ShippingInfo(9, "ms.", "molly", "214 Market Street", "Philadelphia", "PA", 19106));
        shippingInfo.add(new ShippingInfo(10, "mr.", "esteban", "231 McClellan Street", "Philadelphia", "PA", 19148));
        return shippingRepository.saveAll(shippingInfo);
    }
}
