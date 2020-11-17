package com.iwtechnocrat.waljon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iwtechnocrat.waljon.Model.CartModel11;
import com.iwtechnocrat.waljon.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Ad_Cart extends RecyclerView.Adapter<Ad_Cart.Viewholder> {
    Context context;
    List<CartModel11> cartModelListView;

    public Ad_Cart(Context context, List<CartModel11> cartModelListView) {
        this.context = context;
        this.cartModelListView = cartModelListView;
    }

    @NonNull
    @Override
    public Ad_Cart.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_custom,parent,false);
        Ad_Cart.Viewholder viewHolder=new Ad_Cart.Viewholder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Ad_Cart.Viewholder holder, int position) {
        CartModel11 cartModel = cartModelListView.get(position);
        holder.tv_off.setText("OFF"+cartModel.getOff());
        holder.tv_genderfor.setText(cartModel.getGender());
        holder.qnty.setText("Qty"+cartModel.getQnty());
        holder.tv_total_price.setText("Rs."+cartModel.getTotal_price());
        holder.tv_size.setText("Size"+cartModel.getSize());
        holder.tv_shopname.setText(cartModel.getShopname());
        Picasso.get().load(cartModel.getImage()).error(R.mipmap.ic_launcher).into(holder.cart_image);




    }

    @Override
    public int getItemCount() {
        return cartModelListView.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tv_total_price,tv_size,tv_off,tv_shopname,tv_genderfor,qnty;
        ImageView cart_image;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cart_image = itemView.findViewById(R.id.cart_image);
            tv_total_price = itemView.findViewById(R.id.total_price);
            tv_genderfor = itemView.findViewById(R.id.tv_genderfor);
            tv_off = itemView.findViewById(R.id.tv_off);
            tv_size = itemView.findViewById(R.id.tv_size);
            tv_shopname = itemView.findViewById(R.id.shop_name);
            qnty = itemView.findViewById(R.id.tv_qnty);

        }
    }
}
