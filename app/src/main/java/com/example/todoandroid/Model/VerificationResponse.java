package com.example.todoandroid.Model;

public class VerificationResponse {
    private Boolean isVerified;
    private Integer id;

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
