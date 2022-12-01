package SpringBoot.app.user;

import SpringBoot.app.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Primary
@RequiredArgsConstructor
@Service
public class DbUserService implements UserService{
    private final UserRepository repository;

    @Override
    public Set<UserDto> listAll() {
        return null;
    }

    @Override
    public UserDto getById(UUID id) {
        return null;
    }

    @Override
    public UserDto getByName(String lastName, String firstName) {
        return null;
    }

    @Override
    public User save(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto deleteById(UUID id) {
        return null;
    }
}
