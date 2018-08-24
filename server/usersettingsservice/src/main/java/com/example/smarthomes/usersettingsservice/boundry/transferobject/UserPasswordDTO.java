package com.example.smarthomes.usersettingsservice.boundry.transferobject;

public class UserPasswordDTO {

    private String userName;
    private String oldPassword;
    private String newPassword;
    private String reEnteredPassword;

    public String getUserName() {
        return userName;
    }

    public String getReEnteredPassword() {
        return reEnteredPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setReEnteredPassword(String reEnteredPassword) {
        this.reEnteredPassword = reEnteredPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
