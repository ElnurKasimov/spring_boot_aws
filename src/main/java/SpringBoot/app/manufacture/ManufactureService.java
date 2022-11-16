package SpringBoot.app.manufacture;

import SpringBoot.app.product.Product;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class ManufactureService {

    public Set<Manufacture> getAllManufactures() {
        return initializeTestManufactures();
    }

    public Set<Manufacture> initializeTestManufactures() {
        Set<Manufacture> manufactures = new HashSet<>();
        Manufacture manufacture1 = new Manufacture(UUID.randomUUID(), "Bic", new HashSet<>());
        Product product1 = new Product(UUID.randomUUID(), "pen", 100, manufacture1);
        Product product2 = new Product(UUID.randomUUID(), "pencil", 50, manufacture1);
        Product product3 = new Product(UUID.randomUUID(), "eraser", 3, manufacture1);
        Set<Product> products1 = new HashSet<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        manufacture1.setProducts(products1);

        Manufacture manufacture2 = new Manufacture(UUID.randomUUID(), "IKEA", new HashSet<>());
        Product product4 = new Product(UUID.randomUUID(), "book-shelf", 1000, manufacture2);
        Product product5 = new Product(UUID.randomUUID(), "table", 100, manufacture2);
        Product product6 = new Product(UUID.randomUUID(), "chair", 500, manufacture2);
        Set<Product> products2 = new HashSet<>();
        products2.add(product4);
        products2.add(product5);
        products2.add(product6);
        manufacture2.setProducts(products2);


        Manufacture manufacture3 = new Manufacture(UUID.randomUUID(), "Lavazza", new HashSet<>());
        Product product7 = new Product(UUID.randomUUID(), "coffee-machine", 5000, manufacture3);
        Product product8 = new Product(UUID.randomUUID(), "coffee", 100, manufacture3);
        Product product9 = new Product(UUID.randomUUID(), "glass", 5, manufacture3);
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
