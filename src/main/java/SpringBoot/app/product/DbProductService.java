package SpringBoot.app.product;

import SpringBoot.app.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Primary
@RequiredArgsConstructor
@Service
public class DbProductService implements ProductService{
    private final ProductRepository repository;

    @Override
    public Set<ProductDto> listAll() {
        return null;
    }

    @Override
    public ProductDto getById(UUID id) {
        return null;
    }

    @Override
    public ProductDto getByName(String name) {
        return null;
    }

    @Override
    public Product save(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteById(UUID id) {
        return null;
    }
}
