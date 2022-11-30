package SpringBoot.app.role;

import lombok.Data;

import java.util.UUID;


public class Role {
    private UUID id;
    private String name;

    public Role (String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
