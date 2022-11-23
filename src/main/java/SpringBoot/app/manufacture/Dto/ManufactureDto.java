package SpringBoot.app.manufacture.Dto;

import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.product.Product;
import SpringBoot.app.product.dto.ProductConverter;
import SpringBoot.app.product.dto.ProductDto;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ManufactureDto {
    private UUID id;
    private  String name;

    public ManufactureDto() {};

    public ManufactureDto(String name) {
        this.name = name;
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

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
