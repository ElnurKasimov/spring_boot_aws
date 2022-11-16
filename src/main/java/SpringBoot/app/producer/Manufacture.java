package SpringBoot.app.producer;

import SpringBoot.app.product.Product;
import lombok.Data;
import java.util.Set;
import java.util.UUID;
@Data
public class Manufacture {
    private UUID id;
    private  String name;
    Set<Product> products;

}
