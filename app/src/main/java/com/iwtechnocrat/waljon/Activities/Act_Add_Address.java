package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.iwtechnocrat.waljon.R;

public class Act_Add_Address extends AppCompatActivity {
    Button save_address;
    ImageView back;
    RadioGroup radioGroup;
    RadioButton rd_home,rd_office;
    LinearLayout lay_office;
    EditText username,usercity,userpincode,userstate,usermobile,useraddress,userlocality;
    String name ,city,pincode,state,mobile,address,locality,TYPE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__add__address);

        save_address = findViewById(R.id.save_address);
        rd_home = findViewById(R.id.rd_home);
        rd_office = findViewById(R.id.rd_office);
        radioGroup = findViewById(R.id.radioGroup);
        lay_office = findViewById(R.id.lay_office);
        back = findViewById(R.id.back);
        username = findViewById(R.id.username);
        useraddress = findViewById(R.id.useraddress);
        usercity = findViewById(R.id.usercity);
        userlocality = findViewById(R.id.userlocality);
        userpincode = findViewById(R.id.userpincode);
        usermobile = findViewById(R.id.usermobile);
        userstate = findViewById(R.id.userstate);


        save_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = username.getText().toString();
                city = usercity.getText().toString();
                pincode = userpincode.getText().toString();
                state = userstate.getText().toString();
                mobile = usermobile.getText().toString();
                address = useraddress.getText().toString();
                locality = userlocality.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Act_ShowAddress.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_Profile.class);
                startActivity(intent);
            }
        });

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.rd_home:
                        save_address.setBackgroundResource(R.color.dark_blue1);
                        TYPE = "hOME";
                        // TODO Something
                        break;
                    case R.id.rd_office:
                        save_address.setBackgroundResource(R.color.dark_blue1);
                        lay_office.setVisibility(View.VISIBLE);
                        TYPE = "Office";
                        // TODO Something
                        break;

                }
            }
        });

    }
}