package SpringBoot.app.product;

import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.manufacture.ManufactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private  final ProductService productService;
    private final ManufactureService manufactureService;

    @GetMapping("/all")
    public ModelAndView getSetOfProducts() {
        ModelAndView result = new ModelAndView("product/all");
        result.addObject("products", productService.getAllProducts());
        return  result;
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
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setManufacture(manufactureService.getByName(manufactureName));
        System.out.println(product);
        // add product to DB
        return "redirect:/product/all";
    }

}
