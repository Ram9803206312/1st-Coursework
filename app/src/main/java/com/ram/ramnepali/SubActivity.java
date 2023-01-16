package com.ram.ramnepali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SubActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    HobbiesFragment hobbiesFragment = new HobbiesFragment();
    ContactFragment contactFragment = new ContactFragment();
    SkillFragment skillFragment = new SkillFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        bottomNavigationView = findViewById(R.id.bottom_Navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, homeFragment).commit();
                    return true;
                case R.id.profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, profileFragment).commit();
                    return true;

                case R.id.hobby:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, hobbiesFragment).commit();
                    return true;

                case R.id.phone:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, contactFragment).commit();
                    return true;

                case R.id.skill:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, skillFragment).commit();
                    return true;
                default:
                    return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
}