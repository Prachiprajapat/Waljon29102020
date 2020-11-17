package com.iwtechnocrat.waljon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iwtechnocrat.waljon.Model.TopCategoriesModel;
import com.iwtechnocrat.waljon.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Ad_TopCategories extends RecyclerView.Adapter<Ad_TopCategories.viewholder> {
    Context context;
    List<TopCategoriesModel> notificationModelList;

    public Ad_TopCategories(Context context, List<TopCategoriesModel> notificationModelList) {
        this.context = context;
        this.notificationModelList = notificationModelList;
    }

    @NonNull
    @Override
    public Ad_TopCategories.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.topcategory,parent,false);
        Ad_TopCategories.viewholder viewHolder=new Ad_TopCategories.viewholder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Ad_TopCategories.viewholder holder, int position) {
        final TopCategoriesModel notificationModel = notificationModelList.get(position);
        holder.tv_noti.setText(notificationModel.getName());

        Glide.with(context).load(notificationModel.getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return notificationModelList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView tv_noti;
        ImageView image;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tv_noti = itemView.findViewById(R.id.tv_noti);
            image = itemView.findViewById(R.id.image);
        }
    }
}
