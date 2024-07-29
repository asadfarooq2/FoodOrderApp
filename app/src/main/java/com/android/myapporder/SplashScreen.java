package com.android.myapporder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.myapporder.Activity.ActivityLogin;
import com.android.myapporder.Activity.RegistrationActivity;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
//        EdgeToEdge.enable(this);
//            setContentView(R.layout.activity_splash_screen);
//            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//                return insets;
    }
        public void register(View view) {
            startActivity(new Intent(SplashScreen.this, RegistrationActivity.class));
        }

        public void login(View view) {
            startActivity(new Intent(SplashScreen.this, ActivityLogin.class));
        }
    }
