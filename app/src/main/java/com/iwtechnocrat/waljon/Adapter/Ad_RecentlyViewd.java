package com.iwtechnocrat.waljon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iwtechnocrat.waljon.Model.RecentlyViewedModel;
import com.iwtechnocrat.waljon.Model.WishListModel;
import com.iwtechnocrat.waljon.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Ad_RecentlyViewd extends RecyclerView.Adapter<Ad_RecentlyViewd.viewholder> {
    Context context;
    List<RecentlyViewedModel> wishListModels;

    public Ad_RecentlyViewd(Context context, List<RecentlyViewedModel> wishListModels) {
        this.context = context;
        this.wishListModels = wishListModels;
    }

    @NonNull
    @Override
    public Ad_RecentlyViewd.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recently_viewed,parent,false);
        Ad_RecentlyViewd.viewholder viewHolder=new Ad_RecentlyViewd.viewholder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Ad_RecentlyViewd.viewholder holder, int position) {
        RecentlyViewedModel wishListModel = wishListModels.get(position);
        holder.tv_products.setText(wishListModel.getName());
        holder.tv_price.setText("Rs."+" "+wishListModel.getPrice());
        holder.tv_off.setText("off"+" "+wishListModel.getOff());
        Picasso.get().load(wishListModel.getImage()).error(R.mipmap.ic_launcher).into(holder.iv_topcat_img_1);

    }

    @Override
    public int getItemCount() {
        return wishListModels.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView iv_topcat_img_1;
        TextView tv_products,tv_price,tv_off;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            iv_topcat_img_1 = itemView.findViewById(R.id.topcat_img_1);
            tv_products = itemView.findViewById(R.id.tv_product);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_off = itemView.findViewById(R.id.tv_off);
        }
    }
}
