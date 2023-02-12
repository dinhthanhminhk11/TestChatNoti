package com.example.testchatnoti.api;

import com.example.testchatnoti.model.response.Response;
import com.example.testchatnoti.model.user.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiRequest {
    @POST("create")
    Call<Response> registerUser(@Body User user);
}
