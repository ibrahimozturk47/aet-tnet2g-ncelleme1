package com.test.ettnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Anasayfaactivity extends AppCompatActivity {
    Button geçiş;
    ImageView resim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfaactivity);
        geçiş=findViewById(R.id.butonseçim);
        resim=findViewById(R.id.seçimresim);

        Intent gelenintent=getIntent();
        geçiş.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Anasayfaactivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}