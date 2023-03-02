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
import org.alexcawl.health_check_application.databinding.ActivitySettingsBinding;
import org.alexcawl.health_check_application.ui.resource.Route;

public class SettingsActivity extends AppCompatActivity {
    private ActivitySettingsBinding binding;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    @SuppressLint("NonConstantResourceId")
    private void initiateNavigationDrawerMenu() {
        setSupportActionBar(mToolbar);
        mNavigationView.setNavigationItemSelectedListener(new Route(this, this.getClass(), mDrawerLayout));
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, 0, 0);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        init();
        setContentView(binding.getRoot());
        initiateNavigationDrawerMenu();
    }

    private void init() {
        this.mToolbar = binding.activitySettingsToolbar;
        this.mNavigationView = binding.activitySettingsNavigationView;
        this.mDrawerLayout = binding.activitySettingsDrawerLayout;
    }
}