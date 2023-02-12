package com.example.testchatnoti.ui.register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.testchatnoti.model.response.Response;
import com.example.testchatnoti.model.user.User;
import com.example.testchatnoti.repository.Repository;

import java.util.function.Consumer;

public class RegisterViewModel extends AndroidViewModel {

    private MutableLiveData<Response> responseMutableLiveData = new MutableLiveData<>();
    private Repository repository;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public void registerUser(User user){
        repository.registerUser(user, new Consumer<Response>() {
            @Override
            public void accept(Response response) {
                if(response instanceof Response){
                    responseMutableLiveData.postValue(response);
                }
            }
        });
    }

    public MutableLiveData<Response> getResponseMutableLiveData() {
        return responseMutableLiveData;
    }
}
