package org.softuni.pathfinder.model;

import jakarta.persistence.*;
import org.softuni.pathfinder.model.enums.CategoryName;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryName name;

    public Category() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

}
