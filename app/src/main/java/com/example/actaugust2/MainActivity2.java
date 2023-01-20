package com.example.actaugust2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView a;
    TextView b;
    Button c;
    SharedPreferences sp;

    MyReceiver myReceiver= new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a=findViewById(R.id.textView);
        b=findViewById(R.id.textView2);
        c=findViewById(R.id.button3);
        sp=getSharedPreferences("spre",MODE_PRIVATE);

        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(myReceiver,filter);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a.setText(sp.getString("gup","edhaachum"));
                b.setText(sp.getString("shup","chum"));
            }
        });




    }
}