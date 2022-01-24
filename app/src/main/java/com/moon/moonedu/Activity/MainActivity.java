package com.moon.moonedu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Window;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moon.moonedu.Adapter.ViewPagerAdapter;
import com.moon.moonedu.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBtNavMain;
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        initListener();
        setUpViewPager();
    }

    private void initListener() {
        mBtNavMain.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.action_home:
                    break;
                case R.id.action_discover:
                    break;
                case R.id.action_universe:
                    break;
                case R.id.action_all:
                    break;
                case R.id.action_user:
                    break;
            }
            return true;
        });
    }

    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        mViewPager.setAdapter(viewPagerAdapter);

        mBtNavMain.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if(id == R.id.action_home){
                mViewPager.setCurrentItem(0);
            }else if(id == R.id.action_discover){
                mViewPager.setCurrentItem(1);
            }else if(id == R.id.action_universe){
                mViewPager.setCurrentItem(2);
            }else if(id == R.id.action_all){
                mViewPager.setCurrentItem(3);
            }else if(id == R.id.action_user){
                mViewPager.setCurrentItem(4);
            }
            return true;
        });

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mBtNavMain.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        mBtNavMain.getMenu().findItem(R.id.action_discover).setChecked(true);
                        break;
                    case 2:
                        mBtNavMain.getMenu().findItem(R.id.action_universe).setChecked(true);
                        break;
                    case 3:
                        mBtNavMain.getMenu().findItem(R.id.action_all).setChecked(true);
                        break;
                    case 4:
                        mBtNavMain.getMenu().findItem(R.id.action_user).setChecked(true);
                        break;
                }
            }
        });
    }

    private void initUi() {
        mBtNavMain = findViewById(R.id.mainAc_btNav_main);
        mViewPager = findViewById(R.id.mainAc_viewPager);
    }
}