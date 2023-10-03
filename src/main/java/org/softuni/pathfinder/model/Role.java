package org.softuni.pathfinder.model;

import jakarta.persistence.*;
import org.softuni.pathfinder.model.enums.UserRole;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole name;

    public Role() {}

    public UserRole getName() {
        return name;
    }

    public void setName(UserRole name) {
        this.name = name;
    }

}
