package com.example.product.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@Entity(name = "MyUser")
@Getter
@Setter
public class User extends BaseModel{

    private String name;
    private String email;
    private String password;
    @ManyToMany
    private List<Role> roles;
    private boolean isEmailVerified;

    public User() {
    }

}