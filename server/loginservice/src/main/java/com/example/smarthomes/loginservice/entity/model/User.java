package com.example.smarthomes.loginservice.entity.model;

import com.example.smarthomes.loginservice.validators.SQLInjectionAnnotation;
import com.example.smarthomes.loginservice.validators.XSSAnnotation;

import javax.persistence.*;

/**
 * The user entity that holds all the data necessarily information about users , logging, register etc
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "user_name")
    @SQLInjectionAnnotation
    @XSSAnnotation
    private String user_name;

    @Column(name = "password")
    @SQLInjectionAnnotation
    @XSSAnnotation
    private String password;

    public Long getId_user() {
        return id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
