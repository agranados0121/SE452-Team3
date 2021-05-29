package team5.ourstore.Ordering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentInfo")
public class PaymentInfoController {
    @Autowired
    private PaymentInfoRepository paymentRepository;

    public PaymentInfoController(PaymentInfoRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public PaymentInfo addPaymentInfo(PaymentInfo review) {
        return paymentRepository.save(review);
    }

    @GetMapping("/all")
    public List<PaymentInfo> getAll() {
        return paymentRepository.findAll();
    }

    // Test data
    
    public List<PaymentInfo> setUpTestData() {
        List<PaymentInfo> paymentInfo = new ArrayList<>();
        paymentInfo.add(new PaymentInfo(1, "mr.", "chris", "1234432156788765", 123, 19149, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(2, "ms.", "lucy", "4321123487655678", 123, 19135, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(3, "mr.", "mortimer", "2345543267899876", 123, 19140, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(4, "ms.", "matilda", "5432234598766789", 123, 19128, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(5, "mr.", "matthew", "3456654378900987", 123, 19128, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(6, "mr.", "gerald", "6543345609877890", 123, 19123, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(7, "mr.", "bill", "1423253425343645", 123, 19123, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(8, "ms.", "madelyn", "1324253436454756", 123, 19106, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(9, "ms.", "molly", "2534364547565867", 123, 19106, "2024-05-01"));
        paymentInfo.add(new PaymentInfo(10, "mr.", "esteban", "3645475658676978", 123, 19106, "2024-05-01"));
        return paymentRepository.saveAll(paymentInfo);
    }
}
