package org.alexcawl.health_check_application.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.alexcawl.health_check_application.R;
import org.alexcawl.health_check_application.databinding.ActivityAuthenticationBinding;

import java.util.Objects;

public class AuthenticationActivity extends AppCompatActivity {
    private ActivityAuthenticationBinding binding;

    private void hideActionBar() {
        try {
            Objects.requireNonNull(getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }
    }

    private void initBottomNavigationView() {
        BottomNavigationView navView = findViewById(R.id.navigation_bottom_bar_activity_authentication);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.destination_fragment_login, R.id.destination_fragment_register, R.id.destination_home_activity).build();
        NavController navController = Navigation.findNavController(this, R.id.navigation_host_container_auth);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hideActionBar();
        initBottomNavigationView();
    }
}
