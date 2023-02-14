package org.alexcawl.health_check_application.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import org.alexcawl.health_check_application.R;
import org.alexcawl.health_check_application.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbarActivityHome);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navigationView;

        mAppBarConfiguration = appBarConfigurationInitializer(drawer);
        NavController navController = Navigation.findNavController(this, R.id.navigation_host_container_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
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

    private AppBarConfiguration appBarConfigurationInitializer(DrawerLayout drawerLayout) {
        return new AppBarConfiguration
                .Builder(R.id.destination_schedule, R.id.destination_diagram, R.id.destination_settings)
                .setOpenableLayout(drawerLayout)
                .build();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.navigation_host_container_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}