package SpringBoot.app.product;

import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.manufacture.ManufactureService;
import SpringBoot.app.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class InMemoryProductService implements ProductService {
    private Set<Product> products = initializeTestProducts();


    public Set<Product> initializeTestProducts() {
        ManufactureService manufactureService = new ManufactureService();
        Set<Product> products = new HashSet<>();
        for (Manufacture manufacture : manufactureService.getAllManufactures()) {
            products.addAll(manufacture.getProducts());
        }
        return products;
    }


    @Override
    public Set<Product> listAll() {
        return products;
    }

    @Override
    public ProductDto getById(UUID id) {
        return null;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return null;
    }

    @Override
    public Product deleteById(UUID id) {
        return null;
    }
}
