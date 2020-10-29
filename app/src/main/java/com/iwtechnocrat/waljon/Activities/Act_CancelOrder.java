package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.iwtechnocrat.waljon.R;

public class Act_CancelOrder extends AppCompatActivity {
    ImageView back;
    RadioGroup myRadioGroup;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7;
    Button btn_cancel;
    TextView tv_viewpolicy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__cancel_order);

        myRadioGroup = findViewById(R.id.myRadioGroup);
        btn_cancel = findViewById(R.id.btn_cancel);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        rb6 = findViewById(R.id.rb6);
        rb7 = findViewById(R.id.rb7);

        back = findViewById(R.id.back);
        tv_viewpolicy = findViewById(R.id.tv_viewpolicy);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_OrderDetails.class);
                startActivity(intent);
            }
        });

        tv_viewpolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_ViewPolicy.class);
                startActivity(intent);
            }
        });

        RadioGroup rg = (RadioGroup) findViewById(R.id.myRadioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.rb1:
                        btn_cancel.setBackgroundResource(R.color.blue);
                        // TODO Something
                        break;
                    case R.id.rb2:
                        btn_cancel.setBackgroundResource(R.color.blue);


                        // TODO Something
                        break;
                    case R.id.rb3:
                        btn_cancel.setBackgroundResource(R.color.blue);

                        // TODO Something
                        break;
                    case R.id.rb4:
                        btn_cancel.setBackgroundResource(R.color.blue);

                        // TODO Something
                        break;
                    case R.id.rb5:
                        btn_cancel.setBackgroundResource(R.color.blue);

                        // TODO Something
                        break;
                    case R.id.rb6:
                        btn_cancel.setBackgroundResource(R.color.blue);

                        // TODO Something
                        break;
                    case R.id.rb7:
                        btn_cancel.setBackgroundResource(R.color.blue);

                        // TODO Something
                        break;
                }
            }
        });

    }
}