package com.example.duan1_nhom5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManHinhDangKy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man_hinh_dang_ky);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button registerButton = findViewById(R.id.registerButton);
        TextView loginLink = findViewById(R.id.loginLink);
        ImageView backButton = findViewById(R.id.backButton);
        registerButton.setOnClickListener(v -> {
            // Kiểm tra thông tin đăng ký (tên người dùng, mật khẩu, v.v.)
            // Nếu đăng ký thành công:
            Toast.makeText(ManHinhDangKy.this, "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ManHinhDangKy.this , ManHinhDangNhap.class); // Thay MainActivity bằng màn hình chính của bạn
            startActivity(intent);
        });

        loginLink.setOnClickListener(v -> {
            Intent intent = new Intent(ManHinhDangKy.this, ManHinhDangNhap.class); // Chuyển đến màn hình đăng nhập
            startActivity(intent);
        });


        backButton.setOnClickListener(v -> {
            // Quay lại màn hình trước đó
            onBackPressed();  // Hoặc sử dụng finish() nếu muốn đóng activity hiện tại
        });


    }
}