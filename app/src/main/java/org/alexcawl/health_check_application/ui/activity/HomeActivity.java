package org.alexcawl.health_check_application.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.alexcawl.health_check_application.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


}