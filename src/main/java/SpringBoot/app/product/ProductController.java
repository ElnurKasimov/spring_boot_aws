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
        return "/product/getById";
    }

    @PostMapping("/id")
    public ModelAndView getProductById(@RequestParam(name = "id") String id) {
        ModelAndView result = new ModelAndView("product/getById");
        result.addObject("product", inMemoryProductService.getById(UUID.fromString(id)));
        return result;
    }

    @GetMapping("/name")
    public String getProductByName() {
        return "/product/getByName";
    }

    @PostMapping("/name")
    public ModelAndView getProductByName(@RequestParam(name = "name") String name) {
        ModelAndView result = new ModelAndView("product/getByName");
        result.addObject("product", inMemoryProductService.getByName(name));
        return result;
    }

    @GetMapping("/add")
    public ModelAndView getAddProduct() {
        ModelAndView result = new ModelAndView("product/add");
        result.addObject("manufactures", manufactureService.listAll());
        return  result;
    }
    @PostMapping("/add")
    public String postAddProduct(
            @RequestParam ("name") String name,
            @RequestParam ("price") long price,
            @RequestParam ("manufactureName") String manufactureName) {
        ProductDto productDto = new ProductDto(name, price, manufactureService.getByName(manufactureName));
        inMemoryProductService.save(productDto);
        return "redirect:/product/all";
    }

}
