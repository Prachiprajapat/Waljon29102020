package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iwtechnocrat.waljon.Act_Home;
import com.iwtechnocrat.waljon.Adapter.Ad_OrderComplete;
import com.iwtechnocrat.waljon.Model.OrderCompleteModel;
import com.iwtechnocrat.waljon.R;

import java.util.ArrayList;

public class Act_MyOrder extends AppCompatActivity {
    ImageView back;
    RecyclerView recycle_wishlist;
    ArrayList<OrderCompleteModel> orderCompleteModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__my_order);

        back = findViewById(R.id.back);
        recycle_wishlist= findViewById(R.id.recycle_wishlist);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act_Profile.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycle_wishlist.setLayoutManager(linearLayoutManager);
        orderCompleteModels.add(new OrderCompleteModel("1","Delivered","31/10/2020","Daniel Klein","Exclusive man black watch","One:sixe",R.drawable.watch));
        Ad_OrderComplete ad_orderComplete = new Ad_OrderComplete(getApplicationContext(),orderCompleteModels);
        recycle_wishlist.setAdapter(ad_orderComplete);
    }
}