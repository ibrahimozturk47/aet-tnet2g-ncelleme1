package com.test.ettnet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ArrayAdapter<String> itemAdapter;
    private ArrayList<String> items;
    private ListView listview;
    ConstraintLayout arkaplan2;
    private Button button,cıkısbuton2,temabutonsiyah2;
    private ImageView cıkısresim2,temaresimsiyah2;
    private long renk2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        listview=findViewById(R.id.listview);
        button=findViewById(R.id.button);
        cıkısbuton2=findViewById(R.id.cıkısbuton2);
        cıkısresim2=findViewById(R.id.cıkısresimsiyah2);
        temabutonsiyah2=findViewById(R.id.temabutonsiyah2);
        temaresimsiyah2=findViewById(R.id.temasiyahresim2);

        temabutonsiyah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (renk2==0){
                    renk2+=1;
                    arkaplan2.setBackgroundResource(R.drawable.yenipurple);
                }else if (renk2==1){
                    renk2+=1;
                    arkaplan2.setBackgroundResource(R.drawable.yenipurple);
                }else if (renk2==2){
                    renk2+=1;
                    arkaplan2.setBackgroundResource(R.drawable.yeniblue);
                }else if (renk2==3){
                    renk2+=1;
                    arkaplan2.setBackgroundResource(R.drawable.yenigreen);
                }else if (renk2==4){
                    renk2+=1;
                    arkaplan2.setBackgroundResource(R.drawable.yenired);

                }else if (renk2==5){
                    renk2=0;
                    arkaplan2.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });
        cıkısbuton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        items=new ArrayList<>();
        itemAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listview.setAdapter(itemAdapter);
        setUpListViewListener();

    }

    private void setUpListViewListener() {
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Aktivite silindi!", Toast.LENGTH_SHORT).show();
                items.remove(i);
                itemAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }


    private void addItem(View view ){
        EditText input=findViewById(R.id.editTextTextPersonName);
        String itemtext=input.getText().toString();
        if (!(itemtext.equals(""))){
            itemAdapter.add(itemtext);
            input.setText("");
        }else{
            Toast.makeText(this, "Bir aktivite ekleyin", Toast.LENGTH_SHORT).show();
        }

    }


}