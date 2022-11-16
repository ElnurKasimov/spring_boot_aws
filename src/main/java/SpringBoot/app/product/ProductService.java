package SpringBoot.app.product;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService {

    public Set<ProductController> getAllProducts() {
        Set<ProductController> products = new HashSet<>();

        return products;
    }
}
