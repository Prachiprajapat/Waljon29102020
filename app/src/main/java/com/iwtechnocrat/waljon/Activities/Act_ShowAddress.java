package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iwtechnocrat.waljon.Adapter.Ad_ShowAddress;
import com.iwtechnocrat.waljon.Model.ShowAddressModel;
import com.iwtechnocrat.waljon.R;

import java.util.ArrayList;

public class Act_ShowAddress extends AppCompatActivity {
    RecyclerView recyle_showaddress;
    ArrayList<ShowAddressModel>  showAddressModels = new ArrayList<>();
    TextView add_newaadreess;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__show_address);

        back = findViewById(R.id.back);

        recyle_showaddress = findViewById(R.id.recyle_showaddress);
        add_newaadreess = findViewById(R.id.add_newaadreess);
        showAddressModels.add(new ShowAddressModel("1","Prachi Prajapat","34 dahiwar","Dahiwar","Dharmpuri","454552","Madhya Pradesh","9977952100","Home"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        Ad_ShowAddress ad_showAddress = new Ad_ShowAddress(getApplicationContext(),showAddressModels);
        recyle_showaddress.setLayoutManager(linearLayoutManager);
        recyle_showaddress.setAdapter(ad_showAddress);

        add_newaadreess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),Act_Add_Address.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),Act_Profile.class);
                startActivity(intent);
            }
        });

    }
}