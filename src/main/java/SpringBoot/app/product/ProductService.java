package SpringBoot.app.product;

import SpringBoot.app.product.dto.ProductDto;

import java.util.Set;
import java.util.UUID;

public interface ProductService {
    public Set<ProductDto> listAll ();

    public ProductDto getById(UUID id);
    public ProductDto getByName(String name);

    public Product save(ProductDto productDto);

    public Product deleteById(UUID id);
}
