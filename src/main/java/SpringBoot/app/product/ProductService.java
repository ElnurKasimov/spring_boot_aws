package SpringBoot.app.product;

import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.manufacture.ManufactureService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    public Set<Product> getAllProducts() {
        return initializeTestProducts();
    }

    public Set<Product> initializeTestProducts() {
        ManufactureService manufactureService = new ManufactureService();
        Set<Product> products = new HashSet<>();
        for (Manufacture manufacture : manufactureService.getAllManufactures()) {
            products.addAll(manufacture.getProducts());
        }
        return products;
    }


}
