package me.robertjan.sdpr1.controllers;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import me.robertjan.sdpr1.R;
import me.robertjan.sdpr1.models.Photo;

/**
 * Software Development Praktijk 1
 *
 * @author Robert-Jan van der Elst
 * @since 16-11-2019
 */
public class MainActivity extends AppCompatActivity {

    private Photo photo;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
            R.id.navigation_start,
            R.id.navigation_editor,
            R.id.navigation_share
        ).build();

        this.navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, this.navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, this.navController);

        this.photo = new Photo();
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public void navigateTo(int resId) {
        this.navController.navigate(resId);
    }
}
