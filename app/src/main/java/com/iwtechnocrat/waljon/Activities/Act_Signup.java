package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iwtechnocrat.waljon.R;

public class Act_Signup extends AppCompatActivity {
    Button btn_signup,btn_female,btn_male;
    EditText et_password,et_fullname,et_email;
    String password,fullname,email,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__signup2);

        btn_signup = findViewById(R.id.btn_signup);
        btn_female = findViewById(R.id.btn_female);
        btn_male = findViewById(R.id.btn_male);
        et_password = findViewById(R.id.et_password);
        et_email = findViewById(R.id.et_email);
        et_fullname = findViewById(R.id.et_fullname);


        btn_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "Female";
            }
        });

        btn_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "Male";
            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = et_password.getText().toString();
                fullname= et_fullname.getText().toString();
                email = et_email.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Act_Profile.class);
                startActivity(intent);
            }
        });
    }
}