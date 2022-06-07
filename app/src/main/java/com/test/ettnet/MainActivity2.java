package com.test.ettnet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ArrayAdapter<String> itemAdapter;
    ArrayList<String> items;
    private ListView listview;
    ConstraintLayout arkaplan2;
    private Button button,cıkısbuton2;
    private ImageView cıkısresim2;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText input;
    private String isimal;


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
        input=findViewById(R.id.editTextTextPersonName);


        //aktiviteyükle();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
                //Aktivitekaydet();


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
        String itemtext=input.getText().toString();
        //Aktivitekaydet();
        if (!(itemtext.equals(""))){
            itemAdapter.add(itemtext);
            input.setText("");


           Toast.makeText(this, "Aktivite kaydedildi", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Bir aktivite ekleyin", Toast.LENGTH_SHORT).show();
        }

    }
    private void Aktivitekaydet(){
        SharedPreferences sharedPreferences=getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Gson gson=new Gson();
        String json=gson.toJson(items);
        editor.putString("task list",json);
        editor.apply();

    }
    private void aktiviteyükle(){
        SharedPreferences sharedPreferences=getSharedPreferences("shared preferences",MODE_PRIVATE);
        Gson gson=new Gson();
        String json=sharedPreferences.getString("task list",null);
        Type type=new TypeToken<ArrayList<String>>() {}.getType();
        items=gson.fromJson(json,type);
        if (items==null){
            items=new ArrayList<>();
        }
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();



    }



}