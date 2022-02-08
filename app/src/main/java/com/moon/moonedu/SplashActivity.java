package com.moon.moonedu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moon.moonedu.Activity.LogInActivity;
import com.moon.moonedu.Activity.MainActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        CountDownTimer timer = new CountDownTimer(2000, 20) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                nextAc();
            }
        }.start();
    }

    private void nextAc() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            Intent intent = new Intent(this,LogInActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}