package SpringBoot.app.product.dto;

import SpringBoot.app.manufacture.Dto.ManufactureDto;
import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.product.Product;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class ProductDto {
    private UUID id;
    private  String name;
    long price;
    ManufactureDto manufacture;

    public ProductDto() {};

    public ProductDto(String name, long price, ManufactureDto manufacture) {
        this.name = name;
        this.price = price;
        this.manufacture = manufacture;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setManufacture(ManufactureDto manufacture) {
        this.manufacture = manufacture;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public ManufactureDto getManufacture() {
        return manufacture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacture=" + manufacture +
                '}';
    }

    public static ProductDto fromProduct(Product product) {
        ProductDto result = new ProductDto();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setPrice(product.getPrice());
        result.setManufacture(ManufactureDto.fromManufacture(product.getManufacture()));
        return result;
    }

    public Product toProduct() {
        Product result = new Product();
        result.setId(id);
        result.setName(name);
        result.setPrice(price);
        result.setManufacture(manufacture.toManufacture());
        return result;
    }
}
