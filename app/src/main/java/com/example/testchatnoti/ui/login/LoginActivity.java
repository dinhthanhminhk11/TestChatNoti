package com.example.testchatnoti.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.testchatnoti.databinding.ActivityLoginBinding;
import com.example.testchatnoti.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v->{

        });

        binding.register.setOnClickListener(v->{
            startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
        });
    }
}