package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iwtechnocrat.waljon.Act_Home;
import com.iwtechnocrat.waljon.R;


public class Act_Profile extends AppCompatActivity {
    ImageView back;
    LinearLayout lay_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__profile);

        back = findViewById(R.id.back);
        lay_order = findViewById(R.id.lay_order);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Home.class);
                startActivity(intent);
            }
        });

        lay_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_MyOrder.class);
                startActivity(intent);
            }
        });
    }
}