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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moon.moonedu.R;
import com.moon.moonedu.Support.CheckText;

public class LogInActivity extends AppCompatActivity {
    private ConstraintLayout mCtLayoutMain;
    private Animation mAnimFade;
    private TextInputLayout mTilEmail,mTilPassword;
    private TextInputEditText mEtEmail,mEtPassword;
    private Button mBtnLogin;
    private TextView mTvFPassword,mTvRegister;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ProgressDialog mProgressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initUi();
        anim();
        start();
        initListener();


    }

    // Lắng nghe sự kiện
    private void initListener() {
        mBtnLogin.setOnClickListener(v -> {
            String strEmail = mEtEmail.getText().toString();
            String strPassword = mEtPassword.getText().toString();
            if(CheckText.clickCheck(mEtEmail,mTilEmail," email")&&CheckText.clickCheck(mEtPassword,mTilPassword," mật khẩu")){
                mProgressDialog.show();
                mAuth.signInWithEmailAndPassword(strEmail, strPassword)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                mProgressDialog.dismiss();
                                if (task.isSuccessful()) {
                                    // Đăng nhập thành công.
                                    Intent intent = new Intent(LogInActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    finishAffinity();
                                } else {
                                    // Đăng nhập thất bại.
                                    Toast.makeText(LogInActivity.this, "Đăng nhập thất bại.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });

        mTvFPassword.setOnClickListener(v -> {
            Intent intent = new Intent(this,ForgotPasswordActivity.class);
            startActivity(intent);
        });

        mTvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        });
    }

    // khi bắt đầu vào màn hình
    private void start() {
        CheckText.checkEmpty(mEtEmail,mTilEmail," email");
        CheckText.checkEmpty(mEtPassword,mTilPassword," mật khẩu");
        CheckText.checkSpecialCharacters(mEtPassword,mTilPassword," mật khẩu");
    }
    
    private void anim(){
        mCtLayoutMain.setAlpha(1);
        mCtLayoutMain.startAnimation(mAnimFade);
    }

    // ánh xạ
    private void initUi() {
        mCtLayoutMain = findViewById(R.id.loginAc_ctLayout_main);
        mAnimFade = AnimationUtils.loadAnimation(this,R.anim.fade);
        mTilEmail = findViewById(R.id.loginAc_til_email);
        mTilPassword = findViewById(R.id.loginAc_til_password);
        mEtEmail = findViewById(R.id.loginAc_et_email);
        mEtPassword = findViewById(R.id.loginAc_et_password);
        mBtnLogin = findViewById(R.id.loginAc_btn_login);
        mTvRegister = findViewById(R.id.loginAc_tv_register);
        mTvFPassword = findViewById(R.id.loginAc_tv_forgotPassword);

        mDatabase = FirebaseDatabase.getInstance("https://moon-edu-default-rtdb.asia-southeast1.firebasedatabase.app");
        mAuth = FirebaseAuth.getInstance();
        mProgressDialog = new ProgressDialog(this);
    }
}