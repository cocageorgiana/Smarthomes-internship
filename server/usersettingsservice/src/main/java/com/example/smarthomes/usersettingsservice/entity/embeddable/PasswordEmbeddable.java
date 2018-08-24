package com.example.smarthomes.usersettingsservice.entity.embeddable;

public class PasswordEmbeddable {

    private String oldPassword;

    private String reEnteredPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public String getReEnteredPassword() {
        return reEnteredPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setReEnteredPassword(String reEnteredPassword) {
        this.reEnteredPassword = reEnteredPassword;
    }
}
