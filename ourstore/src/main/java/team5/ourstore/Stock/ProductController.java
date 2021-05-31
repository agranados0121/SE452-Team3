package team5.ourstore.Stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    //  Customer / Products
    @PostMapping("/product-page")
    public ModelAndView viewProduct(Product product) {
        ModelAndView model = new ModelAndView("/product-page");
        //  Use . notation to access the data fields/populate product page
        model.addObject("product", product);
        return model;
    }

    //  Admin / Products
    @GetMapping("/admin-home")
    public ModelAndView viewEditForm() {
        ModelAndView model = new ModelAndView("/admin-home");
        Product product = new Product();
        model.addObject("product", product);
        return model;
    }

    @PostMapping("/admin-home")
    public ModelAndView submitEditForm(Product product) {
        ModelAndView model = new ModelAndView("/admin-home");
        for (Product p : getProductCatalog()) {
            if (p.getProductid() == product.getProductid()) {
                removeProductFromCatalog(p);
            }
            addProductToCatalog(product);
        }
        return model;
    }

    public void addProductToCatalog(Product product) {
        productRepository.save(product);
    }

    public void removeProductFromCatalog(Product product) {
        productRepository.delete(product);
    }

    //  Product Getters
    public Product getByProductid(long productId) {
        return productRepository.findByProductid(productId);
    }

    public Product getByCategoryid(long categoryId) {
        return productRepository.findByCategoryid(categoryId);
    }

    public List<Product> getProductCatalog() {
        return productRepository.findAll();
    }

    //  Inventory
    public void updateInventory(long productId, int quantity) {
        Inventory inv = inventoryRepository.findByProductid(productId);
        inv.setQuantity(quantity);
    }

    public Boolean isInStock(Product product) {
        Inventory inv = inventoryRepository.findByProductid(product.getProductid());
        return inv.getQuantity() > 0;
    }

    //  (Discount is inverse)
    //  Add brand/category promotions?
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
