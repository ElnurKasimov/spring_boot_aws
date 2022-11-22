package SpringBoot.app.manufacture.Dto;

import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.product.Product;
import SpringBoot.app.product.dto.ProductDto;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ManufactureDto {
    private UUID id;
    private  String name;
    Set<ProductDto> products;

    public ManufactureDto() {};

    public ManufactureDto(String name, Set<ProductDto> products) {
        this.name = name;
        this.products = products;

    }

    public void setId(UUID id) {
        this.id = id;
    }


    public void setID(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<ProductDto> getProducts() {
        return products;
    }

    public static ManufactureDto fromManufacture(Manufacture manufacture) {
        ManufactureDto result = new ManufactureDto();
        result.setId(manufacture.getId());
        result.setName(manufacture.getName());
        result.setProducts(manufacture.getProducts().stream().map(ProductDto::fromProduct).collect(Collectors.toSet()));
        return result;
    }

    public Manufacture toManufacture() {
        Manufacture result = new Manufacture();
        result.setId(id);
        result.setName(name);
        result.setProducts(products.stream().map(ProductDto::toProduct).collect(Collectors.toSet()));
        return result;
    }

}
