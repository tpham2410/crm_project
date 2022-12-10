package com.cybersoft.crm.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "roles")
public class RoleEntity {
//    CREATE TABLE IF NOT EXISTS roles (
//            id INT NOT NULL AUTO_INCREMENT,
//            name VARCHAR(50) NOT NULL,
//            description VARCHAR(100),
//            PRIMARY KEY (id)
//    );
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "roleEntity")
    private Set<UserEntity> userEntities;

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
