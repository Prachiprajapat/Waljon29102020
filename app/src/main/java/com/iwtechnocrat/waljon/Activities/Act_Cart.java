package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iwtechnocrat.waljon.Act_Home;
import com.iwtechnocrat.waljon.Adapter.Ad_Cart;
import com.iwtechnocrat.waljon.Model.CartModel11;
import com.iwtechnocrat.waljon.R;

import java.util.ArrayList;

public class Act_Cart extends AppCompatActivity {
    ImageView back;
    TextView tv_wishlist;
    BottomSheetBehavior behavior;
    RecyclerView recycle_cart;
    ArrayList<CartModel11> cartModels = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__cart);

        back = findViewById(R.id.back);
        tv_wishlist = findViewById(R.id.wishlist);
        recycle_cart = findViewById(R.id.recycle_cart);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), Act_Home.class);
                startActivity(intent);
            }
        });

        tv_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheet = new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
                //behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }

        });

        cartModels.add(new CartModel11("1",R.drawable.watch,"MINI CLUB","Boys Navy Blue Solid JAcket","6-12","2","645","50"));
        Ad_Cart ad_cart = new Ad_Cart(getApplicationContext(),cartModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycle_cart.setLayoutManager(linearLayoutManager);
        recycle_cart.setAdapter(ad_cart);
    }

}