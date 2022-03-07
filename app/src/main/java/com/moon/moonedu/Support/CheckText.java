package com.moon.moonedu.Support;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckText {
    public static void checkEmpty(TextInputEditText edt, TextInputLayout edtl, String st){
        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(edt.getText().toString().isEmpty()){
                    edtl.setError("Không để trống "+st);

                }else {
                    edtl.setError(null);
                }
            }
        });
    }

    public static void checkSpecialCharacters(TextInputEditText edt, TextInputLayout edtl,String st){
        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(edt.getText().toString());
                boolean b = m.find();
                if(b){
                    edtl.setError(st+" không chứa ký tự đặc biệt");
                }else {
                    edtl.setError(null);
                }
            }
        });
    }

    public static boolean clickCheck(TextInputEditText edt, TextInputLayout edtl,String st){
        if(edt.getText().toString().isEmpty()){
            edtl.setError("Không để trống" + st);
            return false;
        }else {
            edtl.setError(null);
            return true;
        }
    }

    public static boolean clickCheckSpecialCharacters(TextInputEditText edt, TextInputLayout edtl,String st){
        Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(edt.getText().toString());
        boolean b = m.find();
        if(b){
            edtl.setError(st+" không chứa ký tự đặc biệt");
            return false;
        }else {
            edtl.setError(null);
            return true;
        }
    }

    private int hideNavigationBar() {
        return  View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
    }
}
