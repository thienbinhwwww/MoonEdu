package com.moon.moonedu.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.moon.moonedu.R;

public class EditProfileActivity extends AppCompatActivity {
    private EditText mEtFullName,mEtPhone;
    private Button mBtnEdit;
    private FirebaseUser mUserFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initUi();
        initListener();
        setUserInformation();
    }

    private void setUserInformation() {
        if(mUserFb == null){
            return;
        }

        mEtFullName.setText(mUserFb.getDisplayName());
        mEtPhone.setText(mUserFb.getPhoneNumber());
    }

    private void initListener() {
        mBtnEdit.setOnClickListener(v -> {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(mEtFullName.getText().toString())
                    .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                    .build();

            mUserFb.updateProfile(profileUpdates)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("TAG", "User profile updated.");
                            }
                        }
                    });
        });
    }

    private void initUi() {
        mEtFullName = findViewById(R.id.editProfileAc_et_fullName);
        mEtPhone = findViewById(R.id.editProfileAc_et_phone);
        mBtnEdit = findViewById(R.id.editProfileAc_btn_edit);

        mUserFb = FirebaseAuth.getInstance().getCurrentUser();
    }
}