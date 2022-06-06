package com.test.ettnet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.renderscript.Sampler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static long surem = 10000;
    TextView suresiyah;
    LottieAnimationView animasyon2;
    ConstraintLayout arkaplan;
    private Button butonbasladur,anahtarbuton, butonsıfırla,butonseçim,temabutonsiyah,cıkısbuton;
    private ImageView baslaresimsiyah, durdurresimsiyah,anahtarsiyahresim,anahtarbeyazresim,
            sıfırlaresimisiyah,süreresimsiyah,temasiyahresim,cıkısresimsiyah,secimresim;
    private CountDownTimer pomodoro;
    private long renk;
    private boolean geçensure,artısecim,anahtarsecim;
    private long saniye = surem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        butonbasladur = findViewById(R.id.basladurbuton);
        butonsıfırla = findViewById(R.id.butonsıfırla);
        animasyon2=findViewById(R.id.animationView2);
        baslaresimsiyah = findViewById(R.id.baslatresimsiyah);
        secimresim=findViewById(R.id.seçimresim);
        anahtarbeyazresim=findViewById(R.id.anahtarbeyazresim);
        anahtarbuton=findViewById(R.id.anahtarbuton);
        anahtarsiyahresim=findViewById(R.id.anahtarsiyahresim);
        arkaplan=findViewById(R.id.arkaplana);
        durdurresimsiyah = findViewById(R.id.durdurmaresimsiyah);
        sıfırlaresimisiyah = findViewById(R.id.sıfırlaresim);
        butonseçim = findViewById(R.id.butonseçim);
        temabutonsiyah=findViewById(R.id.temabutonsiyah);
        temasiyahresim=findViewById(R.id.temasiyahresim);
        cıkısresimsiyah=findViewById(R.id.cıkısresimsiyah);
        cıkısbuton=findViewById(R.id.cıkısbuton);
        suresiyah = findViewById(R.id.süreyazısiyah);
        durdurresimsiyah.setVisibility(View.INVISIBLE);
        baslaresimsiyah.setVisibility(View.VISIBLE);
        anahtarbuton.setVisibility(View.INVISIBLE);
        anahtarbeyazresim.setVisibility(View.INVISIBLE);
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.beep);
        arkaplan.setBackgroundColor(Color.TRANSPARENT);

        Intent gelenintenti=getIntent();
        temasiyahresim.setVisibility(View.VISIBLE);
        temabutonsiyah.setVisibility(View.VISIBLE);
        animasyon2.setVisibility(View.INVISIBLE);
        butonbasladur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (geçensure) {
                    //durdurma
                    pomodoro.cancel();
                    geçensure = false;
                    baslaresimsiyah.setVisibility(View.VISIBLE);
                    anahtarbuton.setVisibility(View.INVISIBLE);
                    animasyon2.setVisibility(View.INVISIBLE);
                    anahtarbeyazresim.setVisibility(View.INVISIBLE);
                    durdurresimsiyah.setVisibility(View.INVISIBLE);
                    butonsıfırla.setVisibility(View.VISIBLE);
                    suresiyah.setTextColor(Color.parseColor("#000000"));

                } else {
                    //başlama
                    pomodoro = new CountDownTimer(saniye, 1000) {
                        @Override
                        public void onTick(long l) {
                            saniye = l;

                            int dakikam = (int) (saniye / 1000 / 60);
                            int saniyem = (int) (saniye / 1000) % 60;
                            String geçen = String.format(Locale.getDefault(), "%02d:%02d", dakikam, saniyem);
                            suresiyah.setText(geçen);



                        }

                        @Override
                        public void onFinish() {
                            geçensure = false;
                            baslaresimsiyah.setVisibility(View.INVISIBLE);
                            durdurresimsiyah.setVisibility(View.INVISIBLE);
                            butonbasladur.setVisibility(View.INVISIBLE);
                            suresiyah.setTextColor(Color.parseColor("#00ff00"));
                            butonsıfırla.setVisibility(View.VISIBLE);
                            animasyon2.setVisibility(View.INVISIBLE);
                            mediaPlayer.start();
                        }
                    }.start();
                    geçensure = true;
                    baslaresimsiyah.setVisibility(View.INVISIBLE);
                    durdurresimsiyah.setVisibility(View.VISIBLE);
                    anahtarbuton.setVisibility(View.VISIBLE);
                    anahtarbeyazresim.setVisibility(View.VISIBLE);
                    animasyon2.setVisibility(View.VISIBLE);
                    butonsıfırla.setVisibility(View.INVISIBLE);
                    suresiyah.setTextColor(Color.parseColor("#FF0000"));


                }
            }
        });

        butonsıfırla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //güncelleme
                saniye = surem;

                int dakikam = (int) (saniye / 1000 / 60);
                int saniyem = (int) (saniye / 1000) % 60;
                String geçen = String.format(Locale.getDefault(), "%02d:%02d", dakikam, saniyem);
                suresiyah.setText(geçen);
                butonbasladur.setVisibility(View.VISIBLE);
                baslaresimsiyah.setVisibility(View.VISIBLE);
                suresiyah.setTextColor(Color.parseColor("#000000"));

            }
        });




        butonseçim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saniye ==1200000) {
                    saniye =1800000;
                } else if (saniye==1800000){
                    saniye=3600000;
                }
                else if (saniye==3600000){
                    saniye=5400000;
                }else if (saniye==5400000){
                    saniye=7200000;
                }else if (saniye==7200000){
                    saniye=1200000;
                }
                int dakikam = (int) (saniye / 1000 / 60);
                int saniyem = (int) (saniye / 1000) % 60;
                String geçen = String.format(Locale.getDefault(), "%02d:%02d", dakikam, saniyem);
                suresiyah.setText(geçen);
            }


        });
        int dakikam = (int) (saniye / 1000 / 60);
        int saniyem = (int) (saniye / 1000) % 60;
        String geçen = String.format(Locale.getDefault(), "%02d:%02d", dakikam, saniyem);
        suresiyah.setText(geçen);

        temabutonsiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (renk==0){
                    renk+=1;
                    arkaplan.setBackgroundResource(R.drawable.yenipurple);
                }else if (renk==1){
                    renk+=1;
                    arkaplan.setBackgroundResource(R.drawable.yenipurple);
                }else if (renk==2){
                    renk+=1;
                    arkaplan.setBackgroundResource(R.drawable.yeniblue);
                }else if (renk==3){
                    renk+=1;
                    arkaplan.setBackgroundResource(R.drawable.yenigreen);
                }else if (renk==4){
                    renk+=1;
                    arkaplan.setBackgroundResource(R.drawable.yenired);

                }else if (renk==5){
                    renk=0;
                    arkaplan.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });
cıkısbuton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);



    }
});


anahtarbuton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(anahtarsecim==true&&geçensure==true){
            anahtarsecim=false;

            durdurresimsiyah.setVisibility(View.INVISIBLE);
            sıfırlaresimisiyah.setVisibility(View.INVISIBLE);
            butonsıfırla.setVisibility(View.INVISIBLE);
            secimresim.setVisibility(View.INVISIBLE);
            cıkısresimsiyah.setVisibility(View.INVISIBLE);
            cıkısbuton.setVisibility(View.INVISIBLE);
            butonbasladur.setVisibility(View.INVISIBLE);
            anahtarbeyazresim.setVisibility(View.INVISIBLE);
            anahtarsiyahresim.setVisibility(View.VISIBLE);


        }else if(anahtarsecim==false) {
            anahtarsecim=true;
            durdurresimsiyah.setVisibility(View.VISIBLE);
            sıfırlaresimisiyah.setVisibility(View.VISIBLE);
            secimresim.setVisibility(View.VISIBLE);
            cıkısresimsiyah.setVisibility(View.VISIBLE);
            cıkısbuton.setVisibility(View.VISIBLE);
            butonsıfırla.setVisibility(View.VISIBLE);
            anahtarsiyahresim.setVisibility(View.INVISIBLE);
            anahtarbeyazresim.setVisibility(View.VISIBLE);
            butonbasladur.setVisibility(View.VISIBLE);
        }
    }
});

    }

}