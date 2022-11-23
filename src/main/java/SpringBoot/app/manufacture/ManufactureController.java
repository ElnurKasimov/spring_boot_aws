package SpringBoot.app.manufacture;

import SpringBoot.app.product.InMemoryProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    private  final InMemoryManufactureService inMemoryManufactureService;
    private  final InMemoryProductService inMemoryProductService;

    @GetMapping("/all")
    public ModelAndView getSetOfProducts() {
        ModelAndView result = new ModelAndView("manufacture/all");
        result.addObject("manufactures", inMemoryManufactureService.listAll());
        return  result;
    }

    @GetMapping("/id")
    public String getManufactureById() {
        return "/manufacture/getById";
    }

    @PostMapping("/id")
    public ModelAndView getManufactureById(@RequestParam(name = "id") String id) {
        ModelAndView result = new ModelAndView("manufacture/getById");
        result.addObject("manufacture", inMemoryManufactureService.getById(UUID.fromString(id)));
        result.addObject("manufactureProducts", inMemoryProductService.getManufactureProductsById(UUID.fromString(id)));
        return result;
    }

    @GetMapping("/name")
    public String getManufactureByName() {
        return "/manufacture/getByName";
    }

    @PostMapping("/name")
    public ModelAndView getManufactureByName(@RequestParam(name = "name") String name) {
        ModelAndView result = new ModelAndView("manufacture/getByName");
        result.addObject("manufacture", inMemoryManufactureService.getByName(name));
        result.addObject("manufactureProducts", inMemoryProductService.getManufactureProductsByName(name));
        return result;
    }


















    @GetMapping("/create")
    public ModelAndView postCreateManufacture() {
        ModelAndView result = new ModelAndView("create");
        //result.addObject("products", manufactureService.createManufacture());
        return  result;
    }

    @GetMapping("/update")
    public ModelAndView postUpdateManufacture() {
        ModelAndView result = new ModelAndView("update");
        //result.addObject("products", manufactureService.updateManufacture());
        return  result;
    }
    @GetMapping("/delete")
    public ModelAndView postDeleteManufacture() {
        ModelAndView result = new ModelAndView("delete");
        //result.addObject("products", manufactureService.deleteManufacture());
        return  result;
    }

}
