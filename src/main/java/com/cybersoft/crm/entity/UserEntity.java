package com.cybersoft.crm.entity;

import jakarta.persistence.*;

@Entity(name = "users")
public class UserEntity {
//    CREATE TABLE IF NOT EXISTS users (
//            id INT NOT NULL AUTO_INCREMENT,
//            email VARCHAR(100) NOT NULL,
//            password VARCHAR(100) NOT NULL,
//            fullname VARCHAR(100) NOT NULL,
//            avatar VARCHAR(100),
//            role_id INT NOT NULL,
//            PRIMARY KEY (id)
//        );
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "avatar")
    private String avatar;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
