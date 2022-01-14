package com.moon.moonedu.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moon.moonedu.Activity.EditProfileActivity;
import com.moon.moonedu.Activity.LogInActivity;
import com.moon.moonedu.R;

public class UserFragment extends Fragment {
    private LinearLayout mLlEditProfile;
    private View mView;
    private TextView mTvEmail,mTvFullName;
    private FirebaseUser mUserFb;
    private Button mBtnSignOut;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_user,container,false);
        initUi();
        initListener();
        setUserInformation();
        return mView;
    }

    private void setUserInformation() {
        if(mUserFb == null){
            return;
        }

        mTvFullName.setText(mUserFb.getDisplayName());
        mTvEmail.setText(mUserFb.getEmail());
    }

    private void initListener() {
        mLlEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(),EditProfileActivity.class);
            startActivity(intent);
        });

        mBtnSignOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getActivity(), LogInActivity.class);
            startActivity(intent);
            getActivity().finishAffinity();
        });
    }

    private void initUi() {
        mLlEditProfile = mView.findViewById(R.id.userFra_ll_editProfile);
        mTvEmail = mView.findViewById(R.id.userFra_tv_email);
        mTvFullName = mView.findViewById(R.id.userFra_tv_fullName);
        mBtnSignOut = mView.findViewById(R.id.userFra_btn_signOut);

        mUserFb = FirebaseAuth.getInstance().getCurrentUser();
    }
}
