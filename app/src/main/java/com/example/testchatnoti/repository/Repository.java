package com.example.testchatnoti.repository;

import android.util.Log;

import com.example.testchatnoti.api.ApiRequest;
import com.example.testchatnoti.constants.AppConstant;
import com.example.testchatnoti.model.response.Response;
import com.example.testchatnoti.model.user.User;
import com.example.testchatnoti.retrofit.RetrofitRequest;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;


public class Repository {

    private ApiRequest apiRequest;

    public Repository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public void registerUser( User user ,Consumer<Response> consumer ) {
        apiRequest.registerUser(user).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    consumer.accept(response.body());
                } else {
                    Log.e(AppConstant.TAG_MINHCHEK, AppConstant.TAG_ERROR);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e(AppConstant.TAG_MINHCHEK, AppConstant.TAG_ERROR);
            }
        });
    }
}
