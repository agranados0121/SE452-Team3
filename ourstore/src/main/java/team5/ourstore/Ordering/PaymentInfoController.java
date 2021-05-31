package team5.ourstore.Ordering;

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

    @PostMapping
    public PaymentInfo addPaymentInfo(PaymentInfo review) {
        return paymentRepository.save(review);
    }

    @GetMapping("/all")
    public List<PaymentInfo> getAll() {
        return paymentRepository.findAll();
    }
}
