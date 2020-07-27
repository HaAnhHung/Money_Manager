package com.example.money_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.money_manager.Adapter.ViewPagerAdapter;
import com.example.money_manager.Fragment.AddDealFragment;
import com.example.money_manager.Fragment.StatisticFragment;
import com.example.money_manager.Fragment.TodayFragment;
import com.example.money_manager.Interface.IDataChange;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements IDataChange {

    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TodayFragment(), "Hôm nay");
        adapter.addFragment(new AddDealFragment(), "Thêm giao dịch");
        adapter.addFragment(new StatisticFragment(), "Thống kê");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onDataChange() {
        tabLayout.getTabAt(0).select();
    }
}
