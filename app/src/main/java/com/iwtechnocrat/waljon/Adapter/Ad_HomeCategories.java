package com.iwtechnocrat.waljon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iwtechnocrat.waljon.Activities.CategoryPage;
import com.iwtechnocrat.waljon.Model.HomeCatModel;
import com.iwtechnocrat.waljon.Model.SubCatModel;
import com.iwtechnocrat.waljon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ad_HomeCategories extends RecyclerView.Adapter<Ad_HomeCategories.Viewholder> {

    private List<HomeCatModel> homeCateList;
    private Context context;
    private List<SubCatModel> subCatModels = new ArrayList<>();
    int i=0;

    public Ad_HomeCategories(List<HomeCatModel> homeCateList, Context context) {
        this.homeCateList = homeCateList;
        this.context = context;
    }

    @NonNull
    @Override
    public Ad_HomeCategories.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_homeshopcate,parent,false);
        Ad_HomeCategories.Viewholder viewHolder=new Ad_HomeCategories.Viewholder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Ad_HomeCategories.Viewholder holder, int position) {
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));  //bright colors
        final int baseColor = Color.WHITE;

        final int baseRed = Color.red(baseColor);
        final int baseGreen = Color.green(baseColor);
        final int baseBlue = Color.blue(baseColor);

        final int red = (baseRed + rnd.nextInt(256)) / 2;
        final int green = (baseGreen + rnd.nextInt(256)) / 2;
        final int blue = (baseBlue + rnd.nextInt(256)) / 2;
        int clr1 = Color.rgb(red, green, blue);

        final HomeCatModel cc = homeCateList.get(position);

        holder.prodNAme.setText(cc.getName());
        holder.pdetails.setText(cc.getDetail());
      //  holder.image.setImageResource(R.drawable.wlogo11);


        if (cc.getSub_array() == null || cc.getSub_array().length() == 0) {
            holder.pimage.setVisibility(View.GONE);
        }



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.mines)
                {
                    holder.mines = false;
                    if (cc.getSub_array() == null) {


                    } else {
                        holder.recyclerSubCate.setVisibility(View.VISIBLE);
                        holder.pimage.setVisibility(View.GONE);
                        holder.image1.setVisibility(View.VISIBLE);
                        get_subcateory(cc.getSub_array(), holder.recyclerSubCate, cc.getId());
                    }
                }
                else {
                    holder.mines = true;
                    holder.recyclerSubCate.setVisibility(View.GONE);
                    holder.pimage.setVisibility(View.VISIBLE);
                    holder.image1.setVisibility(View.GONE);

                }
            }

        });
    }

    @Override

    public int getItemCount() {
        return homeCateList.size();
    }


    private void get_subcateory(JSONArray response, RecyclerView recyclerView, String cat_id) {

        subCatModels.clear();

        JSONArray array = response;

        if (array.length() == 0) {
            Intent intent = new Intent(context, CategoryPage.class);
            intent.putExtra("cat_id", cat_id);
            context.startActivity(intent);
        } else {


            for (int i = 0; i < array.length(); i++) {

                try {
                    JSONObject object = array.getJSONObject(i);

                    Log.d("sdf", response.toString());
                    object = array.getJSONObject(i);

                    SubCatModel model = new SubCatModel();


                    //model.setDetail(object.getString("description"));
                    model.setId(object.getString("sub_product_id"));
                    //model.setImages(object.getString("image"));
                    model.setName(object.getString("sub_product_name"));

                    if (object.has("subchild")) {
                        model.setSub_array(object.getJSONArray("subchild"));
                    }


                    subCatModels.add(model);

                    SubCatAdapter cateAdapter = new SubCatAdapter(subCatModels, context);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(cateAdapter);
                    cateAdapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public TextView prodNAme, pdetails;
        ImageView image, pimage, image1;
        boolean mines = true;
        RecyclerView recyclerSubCate;
        CardView cardView;
        LinearLayout linearLayout;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            prodNAme = itemView.findViewById(R.id.pNAme);
            pdetails = itemView.findViewById(R.id.pDetails);
            pimage = itemView.findViewById(R.id.image);
            image1 = itemView.findViewById(R.id.image1);
            image = itemView.findViewById(R.id.Pimage);
            recyclerSubCate = itemView.findViewById(R.id.recyclerSubCate);
            cardView = itemView.findViewById(R.id.cardView);
            linearLayout = itemView.findViewById(R.id.ll1);
        }
    }
}
