package SpringBoot.app.manufacture;

import SpringBoot.app.product.Product;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class InMemoryManufactureService {

    public Set<Manufacture> getAllManufactures() {
        //get Manufactures from DB
        return initializeTestManufactures();
    }

    public Manufacture getByName(String manufactureName) {
        // get from DB
        return getAllManufactures().stream().filter(manufacture -> manufacture.getName().equals(manufactureName)).findFirst().orElse(null);
    }

    public Set<Manufacture> initializeTestManufactures() {
        Set<Manufacture> manufactures = new HashSet<>();
        Manufacture manufacture1 = new Manufacture(UUID.randomUUID(), "Bic", new HashSet<>());
        Product product1 = new Product(UUID.fromString("738d8414-b52a-4770-a6ed-f05d7a2c8b7c"), "pen", 100, manufacture1);
        Product product2 = new Product(UUID.fromString("ba307ad4-7a7d-4d6f-accd-4a69ea6d8016"), "pencil", 50, manufacture1);
        Product product3 = new Product(UUID.fromString("040a418e-b2b9-4db3-ad05-70fab977a9bf"), "eraser", 3, manufacture1);
        Set<Product> products1 = new HashSet<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        manufacture1.setProducts(products1);

        Manufacture manufacture2 = new Manufacture(UUID.randomUUID(), "IKEA", new HashSet<>());
        Product product4 = new Product(UUID.fromString("17ad871a-d32b-444f-a821-994edb3d4870"), "book-shelf", 1000, manufacture2);
        Product product5 = new Product(UUID.fromString("072af0e6-776f-4588-803a-ed6d14a92a2d"), "table", 100, manufacture2);
        Product product6 = new Product(UUID.fromString("cc302d72-a595-4b74-a04c-8f062df668b9"), "chair", 500, manufacture2);
        Set<Product> products2 = new HashSet<>();
        products2.add(product4);
        products2.add(product5);
        products2.add(product6);
        manufacture2.setProducts(products2);


        Manufacture manufacture3 = new Manufacture(UUID.randomUUID(), "Lavazza", new HashSet<>());
        Product product7 = new Product(UUID.fromString("3e8fff56-6a3f-4b7f-8577-99fb01e1a934"), "coffee-machine", 5000, manufacture3);
        Product product8 = new Product(UUID.fromString("f73e3b41-fae1-49bb-97e2-fff89b297875"), "coffee", 100, manufacture3);
        Product product9 = new Product(UUID.fromString("2ae76f6d-6ad5-4f2a-8bbe-f018396a330d"), "glass", 5, manufacture3);
        Set<Product> products3 = new HashSet<>();
        products3.add(product7);
        products3.add(product8);
        products3.add(product9);
        manufacture3.setProducts(products3);

        manufactures.add(manufacture1);
        manufactures.add(manufacture2);
        manufactures.add(manufacture3);

        return manufactures;
    }

    public void createManufacture() {

    }

    public void updateManufacture() {

    }

    public void deleteManufacture() {

    }

}
