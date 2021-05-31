package team5.ourstore.Stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.ourstore.Store.Promotion;
import team5.ourstore.Store.PromotionRepository;

@Service
public class ProductService {

    InventoryRepository inventoryRepository;
    ProductRepository productRepository;
    PromotionRepository promotionRepository;
    
    @Autowired
    public ProductService (InventoryRepository inventoryRepository, ProductRepository productRepository, PromotionRepository promotionRepository) {
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

    //  Product Getters
    public Product getByProductid(long productId) {
        return productRepository.findByProductid(productId);
    }

    public Product getProductByCategoryid(long categoryId) {
        return productRepository.findProductByCategoryid(categoryId);
    }

    public List<Product> getAllByCategoryid(long categoryId) {
        List<Product> productsByCategory = new ArrayList<Product>();
        for (Product product : productRepository.findAll()) {
            if (product.getCategoryid() == categoryId) 
                productsByCategory.add(product);
        }
        return productsByCategory;
    }

    public List<Product> getProductCatalog() {
        return productRepository.findAll();
    }

    //  Inventory
    public void updateInventory(long productId) {
        Inventory inv = inventoryRepository.findByProductid(productId);
        inv.setQuantity(inv.getQuantity() - 1);
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
