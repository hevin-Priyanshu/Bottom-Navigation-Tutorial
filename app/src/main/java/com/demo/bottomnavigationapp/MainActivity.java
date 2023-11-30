package com.demo.bottomnavigationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.demo.bottomnavigationapp.Fragments.FragmentA;
import com.demo.bottomnavigationapp.Fragments.FragmentB;
import com.demo.bottomnavigationapp.Fragments.FragmentC;
import com.demo.bottomnavigationapp.Fragments.FragmentD;
import com.demo.bottomnavigationapp.Fragments.FragmentE;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomView);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.homeItem) {
                loadFragment(new FragmentA(), true);
            } else if (id == R.id.searchItem) {
                loadFragment(new FragmentB(), false);
            } else if (id == R.id.profileItem) {
                loadFragment(new FragmentC(), false);
            } else if (id == R.id.contactItem) {
                loadFragment(new FragmentD(), false);
            } else {
                loadFragment(new FragmentE(), false);
            }
            return true;
        });

        bottomNavigationView.setSelectedItemId(R.id.homeItem);
    }

    private void loadFragment(Fragment fragment, boolean flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (flag) {
            fragmentTransaction.add(R.id.frameLayoutView, fragment);
        } else {
            fragmentTransaction.replace(R.id.frameLayoutView, fragment);
        }
        fragmentTransaction.commit();
    }


}