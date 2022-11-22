package SpringBoot.app.manufacture;

import SpringBoot.app.manufacture.Dto.ManufactureDto;
import SpringBoot.app.product.Product;
import SpringBoot.app.product.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryManufactureService implements ManufactureService {
    private Map<UUID, ManufactureDto> manufactures = initializeTestManufactures();


    @Override
    public Set<ManufactureDto> listAll() {
        return new HashSet<>(manufactures.values());
    }

    @Override
    public ManufactureDto getById(UUID id) {
          return manufactures.get(id);
    }

    @Override
    public ManufactureDto getByName(String name) {
        return manufactures.values()
                .stream()
                .filter(manufactureDto -> manufactureDto.getName().equals(name))
                .findFirst().orElse(null);
    }

//    public ManufactureDto getByName(String manufactureName) {
//        // get from DB
//        return getAllManufactures().stream().filter(manufacture -> manufacture.getName().equals(manufactureName)).findFirst().orElse(null);
//    }

    public Map<UUID, ManufactureDto> initializeTestManufactures() {
        Map<UUID, ManufactureDto> manufactures = new HashMap<>();
        ManufactureDto manufacture1 = new ManufactureDto(UUID.fromString("118d8414-b52a-4770-a6ed-f05d7a2c8b7c"), "Bic", new HashSet<>());
        ProductDto product1 = new ProductDto(UUID.fromString("738d8414-b52a-4770-a6ed-f05d7a2c8b7c"), "pen", 100, manufacture1);
        ProductDto product2 = new ProductDto(UUID.fromString("ba307ad4-7a7d-4d6f-accd-4a69ea6d8016"), "pencil", 50, manufacture1);
        ProductDto product3 = new ProductDto(UUID.fromString("040a418e-b2b9-4db3-ad05-70fab977a9bf"), "eraser", 3, manufacture1);
        Set<ProductDto> products1 = new HashSet<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        manufacture1.setProducts(products1);

        ManufactureDto manufacture2 = new ManufactureDto(UUID.fromString("11ad871a-d32b-444f-a821-994edb3d4870"), "IKEA", new HashSet<>());
        ProductDto product4 = new ProductDto(UUID.fromString("17ad871a-d32b-444f-a821-994edb3d4870"), "book-shelf", 1000, manufacture2);
        ProductDto product5 = new ProductDto(UUID.fromString("072af0e6-776f-4588-803a-ed6d14a92a2d"), "table", 100, manufacture2);
        ProductDto product6 = new ProductDto(UUID.fromString("cc302d72-a595-4b74-a04c-8f062df668b9"), "chair", 500, manufacture2);
        Set<ProductDto> products2 = new HashSet<>();
        products2.add(product4);
        products2.add(product5);
        products2.add(product6);
        manufacture2.setProducts(products2);


        ManufactureDto manufacture3 = new ManufactureDto(UUID.fromString("118fff56-6a3f-4b7f-8577-99fb01e1a934"), "Lavazza", new HashSet<>());
        ProductDto product7 = new ProductDto(UUID.fromString("3e8fff56-6a3f-4b7f-8577-99fb01e1a934"), "coffee-machine", 5000, manufacture3);
        ProductDto product8 = new ProductDto(UUID.fromString("f73e3b41-fae1-49bb-97e2-fff89b297875"), "coffee", 100, manufacture3);
        ProductDto product9 = new ProductDto(UUID.fromString("2ae76f6d-6ad5-4f2a-8bbe-f018396a330d"), "glass", 5, manufacture3);
        Set<ProductDto> products3 = new HashSet<>();
        products3.add(product7);
        products3.add(product8);
        products3.add(product9);
        manufacture3.setProducts(products3);

        manufactures.put(manufacture1.getId(),manufacture1);
        manufactures.put(manufacture2.getId(),manufacture2);
        manufactures.put(manufacture3.getId(),manufacture3);

        return manufactures;
    }

    public void createManufacture() {

    }

    public void updateManufacture() {

    }

    public void deleteManufacture() {

    }





    @Override
    public Manufacture save(ManufactureDto manufactureDto) {
        return null;
    }

    @Override
    public Manufacture deleteById(UUID id) {
        return null;
    }
}
