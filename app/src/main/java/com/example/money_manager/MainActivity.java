package com.example.money_manager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.PersistableBundle;

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
    private AddDealFragment addDealFragment = new AddDealFragment();
    private TodayFragment todayFragment = new TodayFragment();
    private StatisticFragment statisticFragment = new StatisticFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDealFragment.setDataChange(this);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(todayFragment, "Hôm nay");
        adapter.addFragment(addDealFragment, "Thêm giao dịch");
        adapter.addFragment(statisticFragment, "Thống kê");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onDataChange() {
        tabLayout.getTabAt(0).select();
    }

    @Override
    public void timeData(String time) {

    }
}
