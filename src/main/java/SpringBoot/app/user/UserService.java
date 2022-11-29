package SpringBoot.app.user;

import SpringBoot.app.product.Product;
import SpringBoot.app.product.dto.ProductDto;
import SpringBoot.app.user.dto.UserDto;

import java.util.Set;
import java.util.UUID;

public interface UserService {
    public Set<UserDto> listAll ();

    public UserDto getById(UUID id);
    public UserDto getByName(String lastName, String firstName);

    public User save(UserDto userDto);

    public UserDto deleteById(UUID id);
}
