package com.moon.moonedu.Fragment.SubFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.moon.moonedu.R;

import java.util.Objects;

public class IntroduceSubFragment extends AppCompatActivity {
    private TextView textIntroduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_sub_fragment);
        Objects.requireNonNull(getSupportActionBar()).hide();
        initUi();
        textIntroduce.setText("Chào mừng bạn đến với Moon Edu , Moon Edu là một ứng dụng học tiếng anh online thuộc dự án tốt nghiệp của nhóm 4 trường Cao đăng FPT Polytechnic do giáo viên Nguyễn Quang Hưng hướng dẫn. Nhóm bao gồm: PH11135 Đỗ Sỹ Phong PH09753 Nguyễn Vĩnh Tiến PH10789 Nguyễn Đức Tuấn PH10839 Nguyễn Tuấn Nghĩa PH08752 Vũ Ngọc Cương PH09802 Hoàng Trung Kết PH09789 Đinh Văn Hưởng Xin cám ơn bạn đã sử dụng ứng dụng của chúng tôi!");

    }
    private void initUi() {
        textIntroduce = findViewById(R.id.text_introduce);
    }
}