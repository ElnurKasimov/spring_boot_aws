package SpringBoot.app.role;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Primary
@RequiredArgsConstructor
@Service
public class DbRoleService implements RoleService{
    private  final RoleRepository repository;

    @Override
    public Set<Role> listAll() {
        return null;
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public Role deleteById(UUID id) {
        return null;
    }

    @Override
    public Role getByName(String name) {
        return null;
    }

    @Override
    public Role getById(UUID id) {
        return null;
    }

    @Override
    public Set<Role> getRolesFromNames(String[] rolesNames) {
        return null;
    }
}
