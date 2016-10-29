package com.demo.chenpf.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.demo.chenpf.fragment.TabOneFragment;
import com.demo.chenpf.fragment.TabThreeFragment;
import com.demo.chenpf.fragment.TabTwoFragment;

/**
 * Created by chenpf on 2016/10/27.
 */

public class TabAdapter extends FragmentStatePagerAdapter {
    int mtabCount;

    public TabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.mtabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabOneFragment();
            case 1:
                return new TabTwoFragment();
            case 2:
                return new TabThreeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mtabCount;
    }
}
