package org.alexcawl.health_check_application.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.alexcawl.health_check_application.databinding.ActivityLoginBinding;
import org.alexcawl.health_check_application.service.ILoginService;
import org.alexcawl.health_check_application.service.LoginService;
import org.jetbrains.annotations.Contract;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private ILoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityLoginBinding.inflate(getLayoutInflater());
        this.loginService = initLoginService();
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
    }

    @NonNull
    private ILoginService initLoginService() {
        return new LoginService();
    }
}
