package SpringBoot.app.user;

import SpringBoot.app.manufacture.ManufactureService;
import SpringBoot.app.manufacture.dto.ManufactureDto;
import SpringBoot.app.product.InMemoryProductService;
import SpringBoot.app.product.dto.ProductDto;
import SpringBoot.app.role.RoleService;
import SpringBoot.app.user.dto.UserDto;
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
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/all")
    public ModelAndView getSetOfUsers() {
        ModelAndView result = new ModelAndView("user/all");
        result.addObject("manufactures", userService.listAll());
        return  result;
    }

    @GetMapping("/id")
    public String getUserById() {
        return "/user/getById";
    }

    @PostMapping("/id")
    public ModelAndView getManufactureById(@RequestParam(name = "id") String id) {
        ModelAndView result = new ModelAndView("user/getById");
        result.addObject("user", userService.getById(UUID.fromString(id)));
        return result;
    }

    @GetMapping("/name")
    public String getManufactureByName() {
        return "/user/getByName";
    }

    @PostMapping("/name")
    public ModelAndView getUserByName(
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "firstName") String firstName ) {
        ModelAndView result = new ModelAndView("user/getByName");
        result.addObject("user", userService.getByName(lastName, firstName));
        return result;
    }

    @GetMapping("/add")
    public String getAddUser() {return "/user/add";
    }
    @PostMapping("/add")
    public String postAddUser(
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "email") String email,
            @RequestParam(value = "roles[]") String[] roles )  {
//        <input type="checkbox" name="roles[]" value="user" />
//        <input type="checkbox" name="roles[]" value="admin" />

        UserDto userDto = new UserDto(lastName, firstName, email, roleService.getRolesFromNames(roles));
        userService.save(userDto);
        return "redirect:/manufacture/all";
    }

    @GetMapping("/error")
    public String getErrorPage () {
        return "/error";
    }

    @GetMapping("/delete")
    public String getDeleteUserById() {
        return "/user/delete";
    }

    @PostMapping("/delete")
    public String postDeleteUserById(@RequestParam ("id") String id) {
        if(userService.getById(UUID.fromString(id)) != null) {
            userService.deleteById(UUID.fromString(id));
            return "redirect:/user/all";}
        else {return "redirect:/error";}
    }

}
