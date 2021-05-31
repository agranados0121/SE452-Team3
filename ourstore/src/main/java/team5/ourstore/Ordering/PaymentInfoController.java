package team5.ourstore.Ordering;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/paymentInfo")
public class PaymentInfoController {

    @Autowired
    private PaymentInfoRepository paymentRepository;

    @GetMapping("/checkout-page")
    public ModelAndView viewPaymentForm() {
        ModelAndView model = new ModelAndView("/checkout-page");
        PaymentInfo paymentInfo = new PaymentInfo();
        model.addObject("paymentInfo", paymentInfo);
        return model;
    }

    @PostMapping("/checkout-page")
    public ModelAndView submitPaymentForm(PaymentInfo paymentInfo) {
        ModelAndView model = new ModelAndView("/checkout-page");
        //  add paymentid to active cart?
        addPaymentInfo(paymentInfo);
        return model;
    }

    @PostMapping
    public PaymentInfo addPaymentInfo(PaymentInfo paymentInfo) {
        return paymentRepository.save(paymentInfo);
    }

    @GetMapping("/all")
    public List<PaymentInfo> getAll() {
        return paymentRepository.findAll();
    }
}
