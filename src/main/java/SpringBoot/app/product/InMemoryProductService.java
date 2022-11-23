package SpringBoot.app.product;

import SpringBoot.app.product.dto.ProductConverter;
import SpringBoot.app.product.dto.ProductDto;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InMemoryProductService implements ProductService {
    @Getter
    private Map<UUID, Product> products = new HashMap<>();


//    public synchronized Map<UUID, Product> initializeTestProducts() {
//        InMemoryManufactureService manufactureService = new InMemoryManufactureService();
//        Map<UUID, Product> products = new HashMap<>();
//        for (ManufactureDto manufacture : manufactureService.listAll()) {
//            manufacture.getProducts()
//                    .forEach(product -> {products.put(product.getId(), ProductConverter.to(product));});
//        }
//        return products;
//    }


    @Override
    public Set<ProductDto> listAll() {
        return products.values().stream().map(ProductConverter::from).collect(Collectors.toSet());
    }

    @Override
    public ProductDto getById(UUID id) {
        return ProductConverter.from(products.get(id));
    }

    @Override
    public ProductDto getByName(String name) {
        return products.values()
                .stream()
                .map(ProductConverter::from)
                .filter(productDto -> productDto.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public synchronized Product save(ProductDto productDto) {

        if (productDto.getId() == null) {
            productDto.setId(UUID.randomUUID());
        }

        products.put(productDto.getId(), ProductConverter.to(productDto));

        return ProductConverter.to(productDto);

    }

    @Override
    public synchronized Product deleteById(UUID id) {
        return null;
    }

    public Set<ProductDto> getManufactureProductsByName(String name) {
        return products.values()
                .stream()
                .map(ProductConverter::from)
                .filter(pr -> pr.getManufacture().getName().equals(name))
                .collect(Collectors.toSet());
    }

    public Set<ProductDto> getManufactureProductsById(UUID id) {
        return products.values()
                .stream()
                .map(ProductConverter::from)
                .filter(pr -> (pr.getManufacture().getId().equals(id)))
                .collect(Collectors.toSet());
    }


}
