package SpringBoot.app.product;

import SpringBoot.app.manufacture.InMemoryManufactureService;
import SpringBoot.app.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private  final InMemoryProductService inMemoryProductService;
    private final InMemoryManufactureService manufactureService;

    @GetMapping("/all")
    public ModelAndView getListOfAllProducts() {
        ModelAndView result = new ModelAndView("product/all");
        result.addObject("products", inMemoryProductService.listAll());
        return  result;
    }

    @GetMapping("/id")
    public String getProductById() {
        return "/product/id";
    }

    @PostMapping("/id")
    public ModelAndView getProductById(@RequestParam(name = "id") String id) {
        ModelAndView result = new ModelAndView("product/id");
        result.addObject("product", inMemoryProductService.getById(UUID.fromString(id)));
        return result;
    }
    @GetMapping("/add")
    public ModelAndView getAddProduct() {
        ModelAndView result = new ModelAndView("product/add");
        result.addObject("manufactures", manufactureService.getAllManufactures());
        return  result;
    }
    @PostMapping("/add")
    public String postAddProduct(
            @RequestParam ("name") String name,
            @RequestParam ("price") long price,
            @RequestParam ("manufactureName") String manufactureName) {
        ProductDto productDto = new ProductDto(name, price, manufactureService.getByName(manufactureName));
        inMemoryProductService.save(productDto);
        // add product to DB
        return "redirect:/product/all";
    }

}
