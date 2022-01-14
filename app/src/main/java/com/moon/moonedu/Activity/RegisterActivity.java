package com.moon.moonedu.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moon.moonedu.R;
import com.moon.moonedu.Support.CheckText;

public class RegisterActivity extends AppCompatActivity {
    private ConstraintLayout mCtLayoutMain;
    private Animation mAnimFade;
    private TextInputLayout mTilEmail,mTilPassword;
    private TextInputEditText mEtEmail,mEtPassword;
    private Button mBtnRegister;
    private TextView mTvLogin;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressDialog;

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
            String strEmail = mEtEmail.getText().toString();
            String strPassword = mEtPassword.getText().toString();

            if(CheckText.clickCheck(mEtEmail,mTilEmail," email")&&CheckText.clickCheck(mEtPassword,mTilPassword," mật khẩu")){
                mProgressDialog.show();
                mAuth.createUserWithEmailAndPassword(strEmail, strPassword)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                mProgressDialog.dismiss();
                                if (task.isSuccessful()) {
                                    // Tạo tại khoản thành công
                                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    finishAffinity();
                                } else {
                                    // Tạo tại khoản thành thất bại
                                    Toast.makeText(RegisterActivity.this, "Đăng ký thất bại",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

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

        mAuth = FirebaseAuth.getInstance();
        mProgressDialog = new ProgressDialog(this);
    }
}