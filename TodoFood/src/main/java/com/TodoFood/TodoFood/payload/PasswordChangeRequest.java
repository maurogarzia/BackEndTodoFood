package com.TodoFood.TodoFood.payload;

public class PasswordChangeRequest {
    private String oldPassword;
    private String newPassword;

    // Getters y Setters

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
