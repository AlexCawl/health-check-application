package org.alexcawl.health_check_application.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import org.alexcawl.health_check_application.databinding.ActivityManagerBinding;
import org.alexcawl.health_check_application.ui.resource.Route;

public class ManagerActivity extends AppCompatActivity {
    private ActivityManagerBinding binding;
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
        this.binding = ActivityManagerBinding.inflate(getLayoutInflater());
        init();
        setContentView(binding.getRoot());
        initiateNavigationDrawerMenu();
    }

    private void init() {
        this.mToolbar = binding.activityManagerToolbar;
        this.mNavigationView = binding.activityManagerNavigationView;
        this.mDrawerLayout = binding.activityManagerDrawerLayout;
    }
}











