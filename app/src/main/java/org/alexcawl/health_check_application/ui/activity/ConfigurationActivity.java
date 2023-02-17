package org.alexcawl.health_check_application.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.alexcawl.health_check_application.R;
import org.alexcawl.health_check_application.databinding.ActivityConfigurationBinding;

public class ConfigurationActivity extends AppCompatActivity {
    private ActivityConfigurationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfigurationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}