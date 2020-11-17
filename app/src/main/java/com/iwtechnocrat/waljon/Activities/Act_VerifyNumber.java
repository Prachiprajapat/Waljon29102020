package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iwtechnocrat.waljon.R;

public class Act_VerifyNumber extends AppCompatActivity {
    ImageView btn_cancel;
    Button btn_continue;
    EditText et_number;
    String number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_verifynumber);

      btn_continue = findViewById(R.id.btn_continue);
        et_number = findViewById(R.id.et_number);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = et_number.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Act_OTP.class);
                startActivity(intent);
            }
        });


    }
    }
