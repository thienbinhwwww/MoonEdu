package com.moon.moonedu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.moon.moonedu.R;
import com.moon.moonedu.Support.CheckText;

public class RegisterActivity extends AppCompatActivity {
    private ConstraintLayout mCtLayoutMain;
    private Animation mAnimFade;
    private TextInputLayout mTilEmail,mTilPassword;
    private TextInputEditText mEtEmail,mEtPassword;
    private Button mBtnRegister;
    private TextView mTvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initUi();
        anim();
        start();
        initListener();
    }

    private void initListener() {
        // Kiểm tra dữ liệu nhập và tạo tại khoản
        mBtnRegister.setOnClickListener(v -> {


        });

        mTvLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this,LogInActivity.class);
            startActivity(intent);
        });
    }

    private void start() {
        // Kiểm tra thay đổi của ô nhập liệu
        CheckText.checkEmpty(mEtEmail,mTilEmail," email");
        CheckText.checkEmpty(mEtPassword,mTilPassword," mật khẩu");
        CheckText.checkSpecialCharacters(mEtPassword,mTilPassword," mật khẩu");
    }

    private void anim() {
        mCtLayoutMain.setAlpha(1);
        mCtLayoutMain.startAnimation(mAnimFade);
    }

    private void initUi() {
        mCtLayoutMain = findViewById(R.id.registerAc_ctLayout_main);
        mAnimFade = AnimationUtils.loadAnimation(this,R.anim.fade);
        mTilEmail = findViewById(R.id.registerAc_til_email);
        mTilPassword = findViewById(R.id.registerAc_til_password);
        mEtEmail = findViewById(R.id.registerAc_et_email);
        mEtPassword = findViewById(R.id.registerAc_et_password);
        mBtnRegister = findViewById(R.id.registerAc_btn_login);
        mTvLogin = findViewById(R.id.registerAc_tv_login);
    }
}