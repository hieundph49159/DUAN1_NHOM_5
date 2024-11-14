package com.example.duan1_nhom5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManHinhLuaChon extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man_hinh_lua_chon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn1 = findViewById(R.id.DangNhap);
        Button btn2 = findViewById(R.id.DangKy);


        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(ManHinhLuaChon.this, ManHinhDangNhap.class); // Thay MainActivity bằng màn hình chính của bạn
            startActivity(intent);

        });

        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(ManHinhLuaChon.this, ManHinhDangKy.class); // Thay MainActivity bằng màn hình chính của bạn
            startActivity(intent);
        });

    }
}