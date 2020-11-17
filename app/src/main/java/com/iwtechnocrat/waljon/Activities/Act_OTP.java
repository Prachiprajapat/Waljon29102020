package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;
import com.iwtechnocrat.waljon.R;

public class Act_OTP extends AppCompatActivity {
    TextView next;
    Pinview et_otp;
    String OTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__o_t_p);

        next = findViewById(R.id.next);
        et_otp = findViewById(R.id.et_otp);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OTP = et_otp.getValue();
                Intent intent = new Intent(getApplicationContext(),Act_Signup.class);
                startActivity(intent);
            }
        });
    }
}