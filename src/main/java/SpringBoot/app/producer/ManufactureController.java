package SpringBoot.app.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    private  final ManufactureService manufactureService;

    @GetMapping("/all")
    public ModelAndView getSetOfProducts() {
        ModelAndView result = new ModelAndView("manufacture/all");
        result.addObject("manufactures", manufactureService.getAllManufactures());
        return  result;
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
