package com.example.smarthomes.register.entity.model;

import com.example.smarthomes.register.validators.EmailAnnotation;
import com.example.smarthomes.register.validators.PasswordAnnotation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "first_name")
//    @NameAnnotation
    private String firstName;

    @Column(name = "last_name")
//    @NameAnnotation
    private String lastName;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "email")
    @EmailAnnotation
    private String email;

    @Column(name = "password")
    @JsonIgnoreProperties
    @PasswordAnnotation
    private String password;

    @JsonCreator
    public User(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("user_name")String user_name, @JsonProperty("email") String email, @JsonProperty("password") String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
