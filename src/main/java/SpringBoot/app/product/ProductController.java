package SpringBoot.app.product;

import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.manufacture.ManufactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
        return  new ModelAndView("product/add");
    }
    @PostMapping("/add")
    public ModelAndView postAddProduct(@ModelAttribute("manufacture") Manufacture manufacture) {
        ModelAndView result = new ModelAndView("product/add");
        result.addObject("manufactures", manufactureService.getAllManufactures());
        System.out.println("Selected manufacture : " + manufacture.getName());
        result.addObject("SelectedManufacture", manufacture.getName());
        return  result;
    }


}
