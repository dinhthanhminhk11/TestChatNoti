package com.example.testchatnoti.model.user;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("userName")
    private String userName;
    @SerializedName("password")
    private String password;
    @SerializedName("name")
    private String name;
    @SerializedName("tokenDevice")
    private String tokenDevice;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String name, String tokenDevice) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.tokenDevice = tokenDevice;
    }

    public User(String id, String userName, String password, String name, String tokenDevice) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.tokenDevice = tokenDevice;
    }
}
