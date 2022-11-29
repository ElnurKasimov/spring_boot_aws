package SpringBoot.app.user;

import SpringBoot.app.role.Role;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Set<Role> roles;

}
