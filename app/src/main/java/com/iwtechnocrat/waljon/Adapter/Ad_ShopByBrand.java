package com.iwtechnocrat.waljon.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iwtechnocrat.waljon.Cart.Myhelper;
import com.iwtechnocrat.waljon.Model.ServicesListModel;
import com.iwtechnocrat.waljon.Model.Shop_by_Brand_model;
import com.iwtechnocrat.waljon.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Ad_ShopByBrand extends RecyclerView.Adapter<Ad_ShopByBrand.ViewHolder> {
    Context context;
    List<Shop_by_Brand_model> shop_by_brand_models;

    String id,status;
    public Ad_ShopByBrand(){}

    public Ad_ShopByBrand(Context context, List<Shop_by_Brand_model> shop_by_brand_models) {
        this.context = context;
        this.shop_by_brand_models = shop_by_brand_models;
    }

    @NonNull
    @Override
    public Ad_ShopByBrand.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_custum,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Ad_ShopByBrand.ViewHolder holder, int position) {

        final Shop_by_Brand_model userListModel = shop_by_brand_models.get(position);

        final Myhelper myhelper = new Myhelper(context);
        final SQLiteDatabase database = myhelper.getWritableDatabase();
        final SQLiteDatabase db=myhelper.getReadableDatabase();

        id=userListModel.getProviderId();
        status=userListModel.getStatus();

        final int[] number = {1};
      //  readCursorData(servicesListModel,holder);
        holder.tv_milk_product.setText(userListModel.getName());
        Picasso.get().load(userListModel.getImage()).error(R.mipmap.ic_launcher).into(holder.topcat_img_1);


        holder.btn_addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.btn_addtocart.getText() == "Added") {
                    Toast.makeText(context, "Item Already Added", Toast.LENGTH_SHORT).show();
                }
                else {
                    Myhelper myhelper=new Myhelper(context);
                    SQLiteDatabase database = myhelper.getReadableDatabase();
                    String sql = "select * from CART";
                    String sql1 = "select count(*) from CART where SERVICE_ID="+userListModel.getKey_id();
                    Cursor cur=db.rawQuery(sql1,null);
                    if (cur != null) {
                        cur.moveToFirst();
                        if (cur.getInt(0) == 0) {
                            Cursor c = database.rawQuery(sql, null);
                            if (c.moveToFirst()) {
                                String Pid = c.getString(6);
                                String sta=c.getString(7);
                                if (Pid.equals(id) && status.equals(sta)) {
                                    cur.moveToFirst();
                                    ContentValues values = new ContentValues();
                                    values.put("SERVICE_NAME", userListModel.getName());
                                    values.put("SERVICE_PRICE", userListModel.getPrice());
                                    values.put("SERVICE_DESC", userListModel.getSample());
                                    values.put("SERVICE_IMAGE", userListModel.getImage());
                                    values.put("QTY", number[0]);
                                    values.put("PROVIDERID", id);
                                    values.put("SERVICE_ID", userListModel.getKey_id());
                                    values.put("STATUS",userListModel.getStatus());
                                    values.put("USERIMAGE",userListModel.getUserimage());
                                    database.insert("CART", null, values);
                                    holder.btn_addtocart.setText("Added");
                                    //  Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
                                } else {
                                    String Pi = c.getString(6);
                                    String st=c.getString(7);
                                    if (!(Pi.equals(id) || status.equals(st))) {
                                        database = myhelper.getWritableDatabase();
                                        database.execSQL("delete from CART");
                                    }
                                    if (cur != null) {
                                        cur.moveToFirst();
                                        if (cur.getInt(0) == 0) {
                                            ContentValues values = new ContentValues();
                                            values.put("SERVICE_NAME", userListModel.getName());
                                            values.put("SERVICE_PRICE", userListModel.getPrice());
                                            values.put("SERVICE_DESC", userListModel.getSample());
                                            values.put("SERVICE_IMAGE", userListModel.getImage());
                                            values.put("QTY", number[0]);
                                            values.put("PROVIDERID", id);
                                            values.put("SERVICE_ID", userListModel.getKey_id());
                                            values.put("STATUS",userListModel.getStatus());
                                            values.put("USERIMAGE",userListModel.getUserimage());
                                            database.insert("CART", null, values);
                                            holder.btn_addtocart.setText("Added");
                                            Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            } else {
                                if (cur != null) {
                                    cur.moveToFirst();
                                    if (cur.getInt(0) == 0) {
                                        ContentValues values = new ContentValues();
                                        values.put("SERVICE_NAME", userListModel.getName());
                                        values.put("SERVICE_PRICE", userListModel.getPrice());
                                        values.put("SERVICE_DESC", userListModel.getSample());
                                        values.put("SERVICE_IMAGE", userListModel.getImage());
                                        values.put("QTY", number[0]);
                                        values.put("PROVIDERID", id);
                                        values.put("SERVICE_ID", userListModel.getKey_id());
                                        values.put("STATUS",userListModel.getStatus());
                                        values.put("USERIMAGE",userListModel.getUserimage());
                                        database.insert("CART", null, values);
                                        holder.btn_addtocart.setText("Added");
                                        //   Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                        else {
                            Toast.makeText(context, "Item Already Added In Your Cart", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return shop_by_brand_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_milk_product;
        ImageView topcat_img_1;
        Button btn_addtocart;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_milk_product = itemView.findViewById(R.id.tv_milk_product);
            topcat_img_1 = itemView.findViewById(R.id.topcat_img_1);
            btn_addtocart = itemView.findViewById(R.id.btn_addtocart);

        }
    }
}
