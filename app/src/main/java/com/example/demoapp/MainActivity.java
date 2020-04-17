package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.demoapp.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        HomeFragment homeFragment = new HomeFragment();
//        fragmentTransaction.add(R.id.containter, homeFragment);
//        fragmentTransaction.commit();
        viewPager2 = findViewById(R.id.viewPager2);

        setupViewPager(viewPager2);
    }

    private void setupViewPager(ViewPager2 viewPager2){

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());
        viewPagerAdapter.addFragment(new SlideOneFragment());
        viewPagerAdapter.addFragment(new SlideTwoFragment());
        viewPagerAdapter.addFragment(new HomeFragment());
        viewPager2.setAdapter(viewPagerAdapter);

    }
}
