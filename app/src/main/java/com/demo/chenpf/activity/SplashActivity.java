package com.demo.chenpf.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.demo.chenpf.constant.Constants;

public class SplashActivity extends AppCompatActivity {
    private boolean isFirstLoad;

    private ImageView mImageView;
    // Splash画面2秒后，自动跳转
    private long sleepMillis = 2000;
    public static final int GOTO_GUIDE_CODE = 1000;
    public static final int GOTO_MAIN_CODE =  1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        // 可为从服务器传来的广告图片，这边暂设为本地静态图片
        mImageView = (ImageView) findViewById(R.id.splash_image);
        mImageView.setBackground(ContextCompat.getDrawable(this,R.drawable.splash));
        SharedPreferences mSharedPreferences = getSharedPreferences(Constants.SharedPerferenceData.SP_NAME, MODE_PRIVATE);
        isFirstLoad = mSharedPreferences.getBoolean(Constants.SharedPerferenceData.SP_KEY_ISFIRSTLOAD,true);

        if (isFirstLoad) { // First Load, Go To GuideActivity
            mHandler.sendEmptyMessageDelayed(GOTO_GUIDE_CODE,sleepMillis);
        } else { // Not First Load, Go To MainActivity
            mHandler.sendEmptyMessageDelayed(GOTO_MAIN_CODE,sleepMillis);
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GOTO_GUIDE_CODE :
                    startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    finish();
                    break;
                case GOTO_MAIN_CODE :
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                    break;
                default:
                    break;
            }
        }
    };
}
