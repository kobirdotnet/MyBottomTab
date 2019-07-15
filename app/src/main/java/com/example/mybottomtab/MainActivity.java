package com.example.mybottomtab;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomBarId);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameViewId,new HomeSubActivity()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                if (menuItem.getItemId() == R.id.HomeId){
                    fragment = new HomeSubActivity();
                }
                if (menuItem.getItemId() == R.id.ProfileId){
                    fragment = new ProfileSubActivity();
                }
                if (menuItem.getItemId() == R.id.SettingId){
                    fragment = new SettingSubActivity();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.FrameViewId,fragment).commit();
                return false;
            }
        });
    }
}
