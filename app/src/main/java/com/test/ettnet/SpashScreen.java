package com.test.ettnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class SpashScreen extends AppCompatActivity {
ImageView resimacılıs;
LottieAnimationView animasyon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        getSupportActionBar().hide();

        resimacılıs=findViewById(R.id.imageView);
        animasyon=findViewById(R.id.animationView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SpashScreen.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        },3000);
    }
}