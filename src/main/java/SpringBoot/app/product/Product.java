package SpringBoot.app.product;

import SpringBoot.app.manufacture.Manufacture;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class Product {
    private UUID id;
    private  String name;
    long price;
    Manufacture manufacture;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setManufacture(Manufacture manufacture) {
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

    public Manufacture getManufacture() {
        return manufacture;
    }
}
