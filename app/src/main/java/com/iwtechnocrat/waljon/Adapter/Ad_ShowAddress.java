package com.iwtechnocrat.waljon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iwtechnocrat.waljon.Model.ShowAddressModel;
import com.iwtechnocrat.waljon.R;

import java.util.List;

public class Ad_ShowAddress extends RecyclerView.Adapter<Ad_ShowAddress.Viewholder> {
    Context context ;
    List<ShowAddressModel>  showAddressModels;

    public Ad_ShowAddress(Context context, List<ShowAddressModel> showAddressModels) {
        this.context = context;
        this.showAddressModels = showAddressModels;
    }

    @NonNull
    @Override
    public Ad_ShowAddress.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_custumaddress,parent,false);
        Ad_ShowAddress.Viewholder viewHolder=new Ad_ShowAddress.Viewholder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Ad_ShowAddress.Viewholder holder, int position) {

        ShowAddressModel showAddressModel  =showAddressModels .get(position);
        holder.houseno.setText(showAddressModel.getHouseno());
        holder.district.setText(showAddressModel.getDistrict());
        holder.name.setText(showAddressModel.getName());
        holder.state.setText(showAddressModel.getState());
        holder.addresstype.setText(showAddressModel.getType());
        holder.mobile.setText(showAddressModel.getMobile());
        holder.pincode.setText(showAddressModel.getPincode());

    }

    @Override
    public int getItemCount() {
        return showAddressModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        Button btn_edit,btn_remove;
        TextView addresstype,name,pincode,district,mobile,state,houseno;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            btn_edit = itemView.findViewById(R.id.edit);
            btn_remove = itemView.findViewById(R.id.remove);
            addresstype = itemView.findViewById(R.id.addresstype);
            name = itemView.findViewById(R.id.name);
            pincode = itemView.findViewById(R.id.pincode);
            district = itemView.findViewById(R.id.district);
            mobile =itemView.findViewById(R.id.mobile);
            state = itemView.findViewById(R.id.state);
            houseno = itemView.findViewById(R.id.houseno);
        }
    }
}
