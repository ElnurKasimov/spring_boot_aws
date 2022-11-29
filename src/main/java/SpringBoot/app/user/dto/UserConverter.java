package SpringBoot.app.user.dto;

import SpringBoot.app.manufacture.Manufacture;
import SpringBoot.app.manufacture.dto.ManufactureDto;
import SpringBoot.app.user.User;

public class UserConverter {

    public static UserDto from(User user) {
        UserDto result = new UserDto();
        result.setId(user.getId());
        result.setLastName(user.getLastName());
        result.setFirstName(user.getFirstName());
        result.setEmail(user.getEmail());
        result.setRoles(user.getRoles());
        return result;
    }

    public static User to(UserDto userDto) {
        User result = new User();
        result.setId(userDto.getId());
        result.setLastName(userDto.getLastName());
        result.setFirstName(userDto.getFirstName());
        result.setEmail(userDto.getEmail());
        result.setRoles(userDto.getRoles());
        return result;
    }

}
