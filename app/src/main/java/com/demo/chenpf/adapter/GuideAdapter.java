package com.demo.chenpf.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by chenpf on 2016/10/26.
 */

public class GuideAdapter extends PagerAdapter {

    private Context mContext;
    private List<View> mViews;

    public GuideAdapter (List<View> views, Context context) {
        this.mContext = context;
        this.mViews = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViews.get(position),0);
        return mViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public int getCount() {
        if (mViews != null) {
            return mViews.size();
        } else {
            return 0;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
