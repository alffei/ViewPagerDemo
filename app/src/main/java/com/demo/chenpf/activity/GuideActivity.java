package com.demo.chenpf.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.chenpf.adapter.GuideAdapter;
import com.demo.chenpf.constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{
    private ViewPager mViewPager;
    private GuideAdapter mPagerAdapter;
    private List<View> mViews;
    private Button mEnterButton;

    // Guide Screen Pics
    private static int[] pics = {
            R.drawable.guide1,
            R.drawable.guide2,
            R.drawable.guide3,
            R.drawable.guide4
    };

    private ImageView[] dots;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
        initDots();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        mEnterButton = (Button) findViewById(R.id.btn_enter_main);
        mEnterButton.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        mViews = new ArrayList<View>();

        for (int i =0; i < pics.length; i++ ) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(layoutParams);
            iv.setImageResource(pics[i]);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mViews.add(iv);
        }

        // Initilize PagerAdapter
        mPagerAdapter = new GuideAdapter(mViews,GuideActivity.this);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(this);

    }

    private void initDots() {
        LinearLayout llDots = (LinearLayout) findViewById(R.id.ll_dot);
        dots = new ImageView[pics.length];

        for (int i = 0; i < pics.length; i++) {
            dots[i] = (ImageView) llDots.getChildAt(i);
            dots[i].setEnabled(true);// 都设为灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);// 设置位置tag，方便取出与当前位置对应
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(false); // 设置为白色，即选中状态
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurDot(position);
    }

    /**
     * Called when the scroll state changes
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setCurDot(int positon) {
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
            return;
        }

        if (positon == pics.length-1) {
            mEnterButton.setVisibility(View.VISIBLE);
        } else {
            mEnterButton.setVisibility(View.GONE);
        }

        dots[positon].setEnabled(false);
        dots[currentIndex].setEnabled(true);
        currentIndex = positon;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_enter_main :
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                setSharedPerferences();
                finish();
                break;
            default:
                break;
        }
    }

    /**
     *
     */
    private void setSharedPerferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.SharedPerferenceData.SP_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Constants.SharedPerferenceData.SP_KEY_ISFIRSTLOAD, false);
        editor.commit();
    }
}
