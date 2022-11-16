package SpringBoot.app.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private  final ProductService productService;

    @GetMapping("/all-products")
    public ModelAndView getSetOfProducts() {
        ModelAndView result = new ModelAndView("all-products");
        result.addObject("products", productService.getAllProducts());
        return  result;
    }
}
