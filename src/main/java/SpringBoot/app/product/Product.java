package SpringBoot.app.product;

import SpringBoot.app.producer.Manufacture;
import lombok.Data;
import java.util.UUID;
@Data
public class Product {
    private UUID id;
    private  String name;
    long price;
    Manufacture manufacture;

}
