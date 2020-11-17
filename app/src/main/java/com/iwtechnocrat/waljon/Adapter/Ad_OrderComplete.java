package com.iwtechnocrat.waljon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iwtechnocrat.waljon.Activities.Act_CancelOrder;
import com.iwtechnocrat.waljon.Activities.Act_OrderDetails;
import com.iwtechnocrat.waljon.Activities.BottomSheetDialog;
import com.iwtechnocrat.waljon.Model.OrderCompleteModel;
import com.iwtechnocrat.waljon.R;
import com.iwtechnocrat.waljon.UI.ItemClickListner;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Ad_OrderComplete extends RecyclerView.Adapter<Ad_OrderComplete.Viewholder> {
    Context context;
    List<OrderCompleteModel> orderCompleteModelList;

    public Ad_OrderComplete(Context context, List<OrderCompleteModel> orderCompleteModelList) {
        this.context = context;
        this.orderCompleteModelList = orderCompleteModelList;
    }

    @NonNull
    @Override
    public Ad_OrderComplete.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_completecustom,parent,false);
        Ad_OrderComplete.Viewholder viewHolder=new Ad_OrderComplete.Viewholder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Ad_OrderComplete.Viewholder holder, int position) {
       OrderCompleteModel orderCompleteModel = orderCompleteModelList.get(position);
       holder.date.setText(orderCompleteModel.getDate());
       holder.deliver_status.setText(orderCompleteModel.getDelivery_status());
       holder.description.setText(orderCompleteModel.getDescription());
       holder.product_name.setText(orderCompleteModel.getProductname());
       holder.size.setText(orderCompleteModel.getSize());
        Picasso.get().load(orderCompleteModel.getImage()).error(R.mipmap.ic_launcher).into(holder.order_image);

        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent = new Intent(context, Act_OrderDetails.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        holder.btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Act_CancelOrder.class);
                context.startActivity(intent);
            }
        });
        holder.btn_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                AppCompatActivity appCompatActivity = new AppCompatActivity();
//                FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
                final BottomSheetDialog bt=new BottomSheetDialog();
                View view= LayoutInflater.from(context).inflate(R.layout.try_layorder,null);
                 return ;


//                com.iwtechnocrat.waljon.Activities.Order_TrackBottomSheet bottomSheetFragment = new      com.iwtechnocrat.waljon.Activities.Order_TrackBottomSheet();
//                bottomSheetFragment.show(((FragmentActivity)context).getSupportFragmentManager(), bottomSheetFragment.getTag());


            }
        });


    }

    @Override
    public int getItemCount() {
        return orderCompleteModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView  order_image;
        TextView deliver_status,date,product_name,description,size;
        private ItemClickListner itemClickListner;
        Button btn_cancel,btn_track;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            order_image = itemView.findViewById(R.id.order_image);
            deliver_status = itemView.findViewById(R.id.deliver_status);
            date = itemView.findViewById(R.id.date);
            product_name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description);
            btn_cancel = itemView.findViewById(R.id.btn_cancel);
            btn_track =itemView.findViewById(R.id.btn_track);
            size = itemView.findViewById(R.id.size);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            this.itemClickListner.onItemClickListner(v,getLayoutPosition());

        }
        public void setItemClickListner(ItemClickListner itemClickListner) {
            this.itemClickListner=itemClickListner;

        }
    }
}
