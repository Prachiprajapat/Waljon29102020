package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwtechnocrat.waljon.R;

public class Act_ViewPolicy extends AppCompatActivity {
    ImageView back;
    TextView que1,que2,que3,que4,que5,que6,que7,que8,que9,que10,que11,que12,que13,que14,que15,que16,que17,
            ans1,ans2,ans3,ans4,ans5,ans6,ans7,ans8,ans9,ans10,ans11,ans12,ans13,ans14,ans15,ans16,ans17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__view_policy);

        back = findViewById(R.id.back);

        que1 = findViewById(R.id.que1);
        que2 = findViewById(R.id.que2);
        que3 = findViewById(R.id.que3);
        que4 = findViewById(R.id.que4);
        que5 = findViewById(R.id.que5);
        que6 = findViewById(R.id.que6);
        que7 = findViewById(R.id.que7);
        que8 = findViewById(R.id.que8);
        que9 = findViewById(R.id.que9);
        que10 = findViewById(R.id.que10);
        que11 = findViewById(R.id.que11);
        que12 = findViewById(R.id.que12);
        que13 = findViewById(R.id.que13);
        que14 = findViewById(R.id.que14);
        que15 = findViewById(R.id.que15);
        que16 = findViewById(R.id.que16);
        que17 = findViewById(R.id.que17);

        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        ans5 = findViewById(R.id.ans5);
        ans6 = findViewById(R.id.ans6);
        ans7 = findViewById(R.id.ans7);
        ans8 = findViewById(R.id.ans8);
        ans9 = findViewById(R.id.ans9);
        ans10 = findViewById(R.id.ans10);
        ans11 = findViewById(R.id.ans11);
        ans12 = findViewById(R.id.ans12);
        ans13 = findViewById(R.id.ans13);
        ans14 = findViewById(R.id.ans14);
        ans15 = findViewById(R.id.ans15);
        ans16 = findViewById(R.id.ans16);
        ans17 = findViewById(R.id.ans17);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Act_CancelOrder.class);
                startActivity(intent);
            }
        });

        que1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  ans1.setVisibility(View.VISIBLE);
                ans1.setVisibility((ans1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans2.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });

        que2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans2.setVisibility((ans2.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
              ans1.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });

        que3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans3.setVisibility((ans3.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });

        que4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans4.setVisibility((ans4.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });

        que5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans5.setVisibility((ans5.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);


            }
        });

        que6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans6.setVisibility((ans6.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });
        que7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans7.setVisibility((ans7.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });

        que8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans8.setVisibility((ans8.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });

        que9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans9.setVisibility((ans9.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);
            }
        });

        que10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans10.setVisibility((ans10.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });

        que11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans11.setVisibility((ans11.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);
            }
        });

        que12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans12.setVisibility((ans12.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);

            }
        });

        que13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans13.setVisibility((ans13.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);



            }
        });

        que14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans14.setVisibility((ans14.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);


            }
        });
        que15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans15.setVisibility((ans15.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);


            }
        });
        que16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans16.setVisibility((ans16.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans17.setVisibility(View.GONE);


            }
        });

        que17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ans1.setVisibility(View.VISIBLE);
                ans17.setVisibility((ans17.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
                ans1.setVisibility(View.GONE);
                ans2.setVisibility(View.GONE);
                ans3.setVisibility(View.GONE);
                ans4.setVisibility(View.GONE);
                ans5.setVisibility(View.GONE);
                ans6.setVisibility(View.GONE);
                ans7.setVisibility(View.GONE);
                ans8.setVisibility(View.GONE);
                ans9.setVisibility(View.GONE);
                ans10.setVisibility(View.GONE);
                ans11.setVisibility(View.GONE);
                ans12.setVisibility(View.GONE);
                ans13.setVisibility(View.GONE);
                ans14.setVisibility(View.GONE);
                ans15.setVisibility(View.GONE);
                ans16.setVisibility(View.GONE);

            }
        });
    }
}