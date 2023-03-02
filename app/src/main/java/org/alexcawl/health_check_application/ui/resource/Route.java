package org.alexcawl.health_check_application.ui.resource;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import org.alexcawl.health_check_application.R;
import org.alexcawl.health_check_application.ui.activity.AccountActivity;
import org.alexcawl.health_check_application.ui.activity.HomeActivity;
import org.alexcawl.health_check_application.ui.activity.ManagerActivity;
import org.alexcawl.health_check_application.ui.activity.SettingsActivity;

import java.util.HashMap;

public class Route implements NavigationView.OnNavigationItemSelectedListener {
    private final Activity activity;
    private final Class<?> aClass;
    private final DrawerLayout drawer;
    private final HashMap<Integer, Class<?>> routes;

    public Route(Activity activity, Class<?> aClass, DrawerLayout drawer) {
        this.activity = activity;
        this.aClass = aClass;
        this.drawer = drawer;
        this.routes = initRoutes();
    }

    private HashMap<Integer, Class<?>> initRoutes() {
        return new HashMap<>() {{
            this.put(R.id.destination_activity_home, HomeActivity.class);
            this.put(R.id.destination_activity_manager, ManagerActivity.class);
            this.put(R.id.destination_activity_account, AccountActivity.class);
            this.put(R.id.destination_activity_settings, SettingsActivity.class);
        }};
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Integer itemID = item.getItemId();
        Class<?> destination = routes.get(itemID);

        if (destination == null) {
            Log.e(String.valueOf(this.getClass()), "destination is null with " + itemID);
            return true;
        }

        if (destination == aClass) {
            drawer.closeDrawer(GravityCompat.START, true);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START, true);
        activity.startActivity(new Intent(activity, destination));
        activity.overridePendingTransition(0, 0);
        return true;
    }
}
