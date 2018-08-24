package com.example.smarthomes.usersettingsservice.entity.model;

import com.example.smarthomes.usersettingsservice.entity.embeddable.PasswordEmbeddable;

import javax.persistence.*;

/**
 * Entity class for mapped to the users table with all the columns
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String newPassword;

    @Embedded
    private PasswordEmbeddable passwordEmbeddable;

    public PasswordEmbeddable getPasswordEmbeddable() {
        return passwordEmbeddable;
    }

    public Integer getId_user() {
        return id_user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNewPassword() {
        return newPassword;
    }


    public String getEmail() {
        return email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPasswordEmbeddable(PasswordEmbeddable passwordEmbeddable) {
        this.passwordEmbeddable = passwordEmbeddable;
    }
}
