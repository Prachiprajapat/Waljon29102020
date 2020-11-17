package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iwtechnocrat.waljon.Act_Home;
import com.iwtechnocrat.waljon.R;


public class Act_Profile extends AppCompatActivity {
    ImageView back;
    LinearLayout lay_order,lay_profiledetails,lay_helpcenter,lay_add_address,card;
    Button login_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__profile);

        back = findViewById(R.id.back);
        lay_order = findViewById(R.id.lay_order);
        login_signup = findViewById(R.id.login_signup);
        lay_profiledetails = findViewById(R.id.lay_profiledetails);
        lay_helpcenter = findViewById(R.id.lay_helpcenter);
        lay_add_address = findViewById(R.id.lay_add_address);
        card = findViewById(R.id.card);


        lay_add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Add_Address.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Home.class);
                startActivity(intent);
            }
        });
        lay_helpcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Act_ChoosLoginWith act_login = new Act_ChoosLoginWith();
                act_login.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });

        lay_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_MyOrder.class);
                startActivity(intent);
            }
        });

        lay_profiledetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_profileDetails.class);
                startActivity(intent);
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_profileDetails.class);
                startActivity(intent);
            }
        });

        login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Act_ChoosLoginWith act_login = new Act_ChoosLoginWith();
                act_login.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });

    }
}