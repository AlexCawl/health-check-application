package org.alexcawl.health_check_application.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.alexcawl.health_check_application.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (this.getIntent().getStringExtra("state") == null
                || !this.getIntent().getStringExtra("state").equals("successful_login")) {
            redirectToLoginActivity();
        }
    }

    private void redirectToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }
}