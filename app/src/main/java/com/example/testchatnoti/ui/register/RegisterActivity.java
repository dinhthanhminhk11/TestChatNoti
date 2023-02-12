package com.example.testchatnoti.ui.register;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testchatnoti.databinding.ActivityRegisterBinding;
import com.example.testchatnoti.model.response.Response;
import com.example.testchatnoti.model.user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    private RegisterViewModel registerViewModel;

    private String tokenDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            return;
                        }
                        String token = task.getResult();
                        tokenDevice = token;
                        Log.d("MinhtokenFirebase", token);
                    }
                });

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        binding.btnRegister.setOnClickListener(v -> {
            registerViewModel.registerUser(new User(binding.edUsername.getText().toString(), binding.edPass.getText().toString(), binding.etName.getText().toString(), tokenDevice));
        });

        registerViewModel.getResponseMutableLiveData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.isStatus()) {
                    Toast.makeText(RegisterActivity.this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.register.setOnClickListener(v -> {
            finish();
        });
    }
}