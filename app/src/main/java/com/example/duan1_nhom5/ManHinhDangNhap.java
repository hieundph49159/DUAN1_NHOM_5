package com.example.duan1_nhom5;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManHinhDangNhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man_hinh_dang_nhap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button loginButton = findViewById(R.id.loginButton);
        TextView registerLink = findViewById(R.id.registerLink);
        ImageView backButton = findViewById(R.id.backButton);
        loginButton.setOnClickListener(v -> {
            // Kiểm tra thông tin đăng nhập (tên người dùng, mật khẩu, v.v.)
            // Nếu đăng nhập thành công:
            Intent intent = new Intent(); // Thay MainActivity bằng màn hình chính của bạn
            startActivity(intent);
            finish(); // Kết thúc Activity đăng nhập để không quay lại được
        });


        registerLink.setOnClickListener(v -> {
            Intent intent = new Intent(ManHinhDangNhap.this, ManHinhDangKy.class); // Chuyển đến màn hình đăng ký
            startActivity(intent);
        });


        backButton.setOnClickListener(v -> {
            // Quay lại màn hình trước đó
            onBackPressed();  // Hoặc sử dụng finish() nếu muốn đóng activity hiện tại
        });

        //12313ad
    }
}