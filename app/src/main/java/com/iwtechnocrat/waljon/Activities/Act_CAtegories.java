package com.iwtechnocrat.waljon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.iwtechnocrat.waljon.Adapter.Ad_HomeCategories;
import com.iwtechnocrat.waljon.Model.HomeCatModel;
import com.iwtechnocrat.waljon.R;

import java.util.ArrayList;
import java.util.List;

public class Act_CAtegories extends BottomSheetDialogFragment {

    RecyclerView recyclerView;
    RecyclerView recyclerSubCate;
    Ad_HomeCategories cateAdapter, subCateAdapter;
    ProgressDialog progressDialog;
    String catId;
    Gson gson;
    private List<HomeCatModel> cateList = new ArrayList<>();
    private List<HomeCatModel> subcateList = new ArrayList<>();
    private boolean isSubcat = false;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.category_dialog, container, false);
        recyclerView = view.findViewById(R.id.recyclerCAte);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayout);

          cateList.add(new HomeCatModel("Makeup","1"," description"));
          cateList.add(new HomeCatModel("Skin","2"," description"));
          cateList.add(new HomeCatModel("Hair","3"," description"));
          cateList.add(new HomeCatModel("Aplliances","4"," description"));
          cateList.add(new HomeCatModel("Personal Care","5"," description"));
          cateList.add(new HomeCatModel("Fashion  Jwellery","6"," description"));
          cateList.add(new HomeCatModel("Foot wear  ","7"," description"));
          cateList.add(new HomeCatModel("Bags  ","8"," description"));
          cateList.add(new HomeCatModel("Sunglasses and frames  ","9"," description"));
          cateList.add(new HomeCatModel("Undergarmentd  ","10"," description"));
          cateList.add(new HomeCatModel("Ladies Wears  ","11"," description"));
          cateList.add(new HomeCatModel("Watches and belts  ","11"," description"));

          cateAdapter = new Ad_HomeCategories(cateList,getContext());
          recyclerView.setAdapter(cateAdapter);

        return view;
    }
}