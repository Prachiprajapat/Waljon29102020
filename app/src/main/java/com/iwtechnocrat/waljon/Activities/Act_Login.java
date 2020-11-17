package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iwtechnocrat.waljon.Act_Home;
import com.iwtechnocrat.waljon.R;

public class Act_Login extends AppCompatActivity {
    Button btn_login;
    ImageView back;
    EditText et_number,et_password;
    String number,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__login);


        btn_login = findViewById(R.id.btn_login);
        back = findViewById(R.id.back);
        et_number = findViewById(R.id.et_number);
        et_password = findViewById(R.id.et_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = et_number.getText().toString();
                password = et_password.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Act_Home.class);
                startActivity(intent);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Act_ChoosLoginWith act_login = new Act_ChoosLoginWith();
                act_login.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });
    }
}