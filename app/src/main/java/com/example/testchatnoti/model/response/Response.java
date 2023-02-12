package com.example.testchatnoti.model.response;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("status")
    private boolean status;
    @SerializedName("message")
    private String message;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
