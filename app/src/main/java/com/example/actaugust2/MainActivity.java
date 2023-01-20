package com.example.actaugust2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText a;
    EditText b;
    Button c;
    Button d;
    SharedPreferences sp;
    SharedPreferences.Editor ed;

    MyReceiver myReceiver= new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.editTextTextPersonName);
        b=findViewById(R.id.editTextTextPersonName2);
        c=findViewById(R.id.button);
        d=findViewById(R.id.button2);

        sp=getSharedPreferences("spre",MODE_PRIVATE);
        ed= sp.edit();


        IntentFilter filter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);

        registerReceiver(myReceiver,filter);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.putString("gup",a.getText().toString());
                ed.putString("shup",b.getText().toString());
                ed.commit();

            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qwer=new Intent(MainActivity.this,MainActivity2.class);

                startActivity(qwer);
            }
        });

    }
}