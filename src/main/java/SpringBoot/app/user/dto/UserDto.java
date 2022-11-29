package SpringBoot.app.user.dto;

import SpringBoot.app.role.Role;
import lombok.Data;

import java.util.Set;
import java.util.UUID;


public class UserDto {
    private UUID id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Set<Role> roles;

    public UserDto() {}

    public UserDto ( String lastName, String firstName, String email,  Set<Role> roles) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
