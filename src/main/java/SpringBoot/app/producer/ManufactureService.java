package SpringBoot.app.producer;

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
        Product product3 = new Product(UUID.randomUUID(), "lastic", 3, manufacture1);
        Set<Product> products1 = new HashSet<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        manufacture1.setProducts(products1);

        Manufacture manufacture2 = new Manufacture(UUID.randomUUID(), "IKEA", new HashSet<>());
        Product product4 = new Product(UUID.randomUUID(), "kabinet", 1000, manufacture1);
        Product product5 = new Product(UUID.randomUUID(), "table", 100, manufacture1);
        Product product6 = new Product(UUID.randomUUID(), "chair", 500, manufacture1);
        Set<Product> products2 = new HashSet<>();
        products2.add(product4);
        products2.add(product5);
        products2.add(product6);
        manufacture2.setProducts(products2);


        Manufacture manufacture3 = new Manufacture(UUID.randomUUID(), "Lavazza", new HashSet<>());
        Product product7 = new Product(UUID.randomUUID(), "mashine", 5000, manufacture1);
        Product product8 = new Product(UUID.randomUUID(), "coffee", 100, manufacture1);
        Product product9 = new Product(UUID.randomUUID(), "glass", 5, manufacture1);
        Set<Product> products3 = new HashSet<>();
        products3.add(product9);
        products3.add(product5);
        products3.add(product6);
        manufacture2.setProducts(products2);

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
