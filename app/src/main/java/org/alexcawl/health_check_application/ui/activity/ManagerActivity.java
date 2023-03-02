package org.alexcawl.health_check_application.ui.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import org.alexcawl.health_check_application.R;
import org.alexcawl.health_check_application.databinding.ActivityAccountBinding;
import org.alexcawl.health_check_application.databinding.ActivityManagerBinding;

public class ManagerActivity extends AppCompatActivity {
    private ActivityManagerBinding binding;

    @SuppressLint("NonConstantResourceId")
    private void initiateNavigationDrawerMenu() {
        Toolbar toolbar = binding.activityManagerToolbar;
        NavigationView navigationView = binding.activityManagerNavigationView;
        DrawerLayout drawerLayout = binding.activityManagerDrawerLayout;
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(item -> {
            drawerLayout.closeDrawer(navigationView, true);
            switch (item.getItemId()) {
                case R.id.destination_activity_home:
                    startActivity(new Intent(this, HomeActivity.class));
                    overridePendingTransition(0, 0);
                    break;
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
        this.binding = ActivityManagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initiateNavigationDrawerMenu();
    }
}