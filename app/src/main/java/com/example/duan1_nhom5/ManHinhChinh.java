package com.example.duan1_nhom5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.duan1_nhom5.databinding.ActivityManHinhChinhBinding;
import com.example.duan1_nhom5.frag.AccountFragment;
import com.example.duan1_nhom5.frag.CartFragment;
import com.example.duan1_nhom5.frag.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class ManHinhChinh extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityManHinhChinhBinding binding;
    private DrawerLayout drawerLayout;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Khởi tạo binding
        binding = ActivityManHinhChinhBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Thiết lập Edge-to-Edge và Toolbar
        EdgeToEdge.enable(this);
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        // Thiết lập DrawerLayout và ActionBarDrawerToggle
        drawerLayout = binding.drawerLayout;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Áp dụng Window Insets cho hệ thống thanh trạng thái và thanh điều hướng cái này có mặc định
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Đặt Fragment mặc định là HomeFragment
        replaceFragment(new HomeFragment());

        // Cài đặt sự kiện cho BottomNavigationView
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.giohang) {
                replaceFragment(new CartFragment());
            } else if (itemId == R.id.taikhoan) {
                replaceFragment(new AccountFragment());
            }

            return true;
        });

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    // Hàm thay thế Fragment
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.menu_home) {
            replaceFragment(new HomeFragment());
            binding.bottomNavigationView.setSelectedItemId(R.id.home);
        } else if (i == R.id.menu_cart) {
            replaceFragment(new CartFragment());
            binding.bottomNavigationView.setSelectedItemId(R.id.giohang);
        } else if (i == R.id.menu_account) {
            replaceFragment(new AccountFragment());
            binding.bottomNavigationView.setSelectedItemId(R.id.taikhoan);
        } else if (i == R.id.logout) {
            Intent intent = new Intent(ManHinhChinh.this, ManHinhDangNhap.class);
            startActivity(intent);
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
       if(drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
       }else{
           super.onBackPressed();
       }
    }
}
