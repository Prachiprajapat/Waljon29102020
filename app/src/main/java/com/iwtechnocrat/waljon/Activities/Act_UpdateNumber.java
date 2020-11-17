package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iwtechnocrat.waljon.R;

public class Act_UpdateNumber extends AppCompatActivity {
    ImageView back;
    EditText et_number;
    Button btn_continue;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__update_number);

        et_number = findViewById(R.id.et_number);
        btn_continue = findViewById(R.id.btn_continue);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_profileDetails.class);
                startActivity(intent);
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                number = et_number.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Act_profileDetails.class);
                startActivity(intent);
            }
        });
    }
}