package org.alexcawl.health_check_application.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import org.alexcawl.health_check_application.R;
import org.alexcawl.health_check_application.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @SuppressLint("NonConstantResourceId")
    private void initiateNavigationDrawerMenu() {
        Toolbar toolbar = binding.activityHomeToolbar;
        NavigationView navigationView = binding.activityHomeNavigationView;
        DrawerLayout drawerLayout = binding.activityHomeDrawerLayout;
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(item -> {
            drawerLayout.closeDrawer(navigationView, true);
            switch (item.getItemId()) {
                case R.id.destination_activity_account:
                    startActivity(new Intent(this, AccountActivity.class));
                    overridePendingTransition(0, 0);
                    break;
                case R.id.destination_activity_settings:
                    startActivity(new Intent(this, SettingsActivity.class));
                    overridePendingTransition(0, 0);
                    break;
                default:
                    break;
            }
            return false;
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initiateNavigationDrawerMenu();
    }
}