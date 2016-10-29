package com.demo.chenpf.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.demo.chenpf.adapter.TabAdapter;

import static com.demo.chenpf.activity.R.id.tabLayout;

/**
 *  TabLayout + ViewPager + PagerAdapter(FragmentStatePagerAdapter)
 *  实现通过Tab形式滑动切换Fragment
 */
public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private TabAdapter mTabAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TabLayout
        mTabLayout = (TabLayout) findViewById(tabLayout);
        mTabLayout.setBackground(ContextCompat.getDrawable(MainActivity.this,R.color.md_light_green_400));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_one_title));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_two_title));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_three_title));
        // FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // FragmentStatePagerAdapter
        mTabAdapter = new TabAdapter(fragmentManager,mTabLayout.getTabCount());
        // ViewPager
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mTabAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






    }
}
