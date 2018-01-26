package com.example.study.android.androidscreening.ui;

import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.study.android.androidscreening.R;

import java.util.List;


public class ScreeningActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private LinearLayout navigationView;
    private RightSideslipLay menuHeaderView;
    private TextView mFrameTv;

    private TextView first;
    private TextView second;
    private TextView third;
    private TextView fourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (LinearLayout) findViewById(R.id.nav_view);
        mFrameTv = (TextView) findViewById(R.id.screenTv);
        first=(TextView)findViewById(R.id.first_value);
        second=(TextView)findViewById(R.id.second_value);
        third=(TextView)findViewById(R.id.third_value);
        fourth=(TextView)findViewById(R.id.fourth_value);

        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);

        menuHeaderView = new RightSideslipLay(ScreeningActivity.this);
        navigationView.addView(menuHeaderView);
        mFrameTv.setOnClickListener(new OnClickListenerWrapper() {
            @Override
            protected void onSingleClick(View v) {
                openMenu();
            }
        });
        menuHeaderView.setLAttrCallBack(new RightSideslipLay.SelectDataCallBack() {
            @Override
            public void setupAttr(List<String> mSelectData) {
                Log.d("denies",mSelectData.toString());
            }
        });
        menuHeaderView.setCloseMenuCallBack(new RightSideslipLay.CloseMenuCallBack() {
            @Override
            public void setupCloseMean() {
                closeMenu();
            }
        });

    }

    public void closeMenu() {
        drawer.closeDrawer(GravityCompat.END);
    }

    public void openMenu() {
        drawer.openDrawer(GravityCompat.END);
    }



}
