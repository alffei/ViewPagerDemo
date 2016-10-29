package com.demo.chenpf.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * Created by chenpf on 2016/10/28.
 */

public class UpFilpView extends ViewFlipper {
    private Context mContext;
    private final int milisec = 8000;

    public UpFilpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setFlipInterval(milisec);
    }

    // 自定义方法
    public void setViews(List<View> views) {
        if (views == null || views.size() == 0) return;

        removeAllViews();

        for (int i = 0; i < views.size(); i++) {
            addView(views.get(i));
        }
        startFlipping();
    }
}
