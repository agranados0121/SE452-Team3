package team5.ourstore.Stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team5.ourstore.Store.Promotion;
import team5.ourstore.Store.PromotionRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;
    private PromotionRepository promotionRepository;

    @Autowired
    public ProductController (InventoryRepository inventoryRepository, ProductRepository productRepository, PromotionRepository promotionRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.promotionRepository = promotionRepository;
    }
    
    public void addProductToCatalog(Product product) {
        productRepository.save(product);
    }

    public void removeProductFromCatalog(Product product) {
        productRepository.delete(product);
    }

    public Product getByProductid(long productId) {
        return productRepository.findByProductid(productId);
    }

    public List<Product> getProductCatalog() {
        return productRepository.findAll();
    }

    public void updateInventory(long productId, int quantity) {
        Inventory inv = inventoryRepository.findByProductid(productId);
        inv.setQuantity(quantity);
    }

    public Boolean isInStock(Product product) {
        System.out.println("Testing... isInStock ran...");
        Inventory inv = inventoryRepository.findByProductid(product.getProductid());
        return inv.getQuantity() > 0;
    }

    //  Discount is inverse
    public float getDiscount(long productId) {
        float discount = 1;
        List<Promotion> promotions = promotionRepository.findAll();
        for (Promotion promo : promotions) {
            if (promo.getProductid() == productId) {
                if (discount > promo.getDiscount()) {
                    discount = promo.getDiscount();
                }
            }
        }
        return discount;
    }  
}
