package SpringBoot.app.product.dto;

import SpringBoot.app.manufacture.dto.ManufactureConverter;
import SpringBoot.app.product.Product;


public class ProductConverter {

    public static ProductDto from(Product product) {
        ProductDto result = new ProductDto();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setPrice(product.getPrice());
        result.setManufacture(ManufactureConverter.from(product.getManufacture()));
        return result;
    }

    public static Product to(ProductDto productDto) {
        Product result = new Product();
        result.setId(productDto.getId());
        result.setName(productDto.getName());
        result.setPrice(productDto.getPrice());
        result.setManufacture(ManufactureConverter.to(productDto.getManufacture()));
        return result;
    }
}
