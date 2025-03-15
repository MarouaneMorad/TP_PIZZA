package com.example.tp_pizza;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
    private ImageView logoImage;
    private TextView appTitle, appSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        logoImage = findViewById(R.id.logoImage);
        appTitle = findViewById(R.id.appTitle);
        appSlogan = findViewById(R.id.appSlogan);
        findViewById(R.id.main).setBackgroundColor(Color.RED);
        // Charger et démarrer les animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        logoImage.startAnimation(fadeIn);
        appTitle.startAnimation(fadeIn);
        appSlogan.startAnimation(fadeIn);




        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent intent = new Intent(SplashActivity.this, ListPizzaActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }
}