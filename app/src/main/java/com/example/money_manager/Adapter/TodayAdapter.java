package com.example.money_manager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.money_manager.Model.Deal;
import com.example.money_manager.Model.DealToday;
import com.example.money_manager.R;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.MyViewHolder> {

    //private Context mContext;
    private List<Deal> dealList =  new ArrayList<>();

    public TodayAdapter() {
    }

    public TodayAdapter(List<Deal> dealList) {
        this.dealList = dealList;
    }

    @NonNull
    @Override
    public TodayAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.today_item, parent, false);

        return new TodayAdapter.MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayAdapter.MyViewHolder holder, int position) {

        holder.group_today_tv.setText(dealList.get(position).getGroup());
        holder.money_today_tv.setText(dealList.get(position).getMoney());

//        holder.group_today_tv.setText("Ăn uống");
//        holder.money_today_tv.setText("50000");
}

    @Override
    public int getItemCount() {
        return dealList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView group_today_tv, money_today_tv;
        private CardView today_cardview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            group_today_tv = itemView.findViewById(R.id.group_today_tv);
            money_today_tv = itemView.findViewById(R.id.money_today_tv);
            today_cardview = itemView.findViewById(R.id.today_cardview);
        }
    }
}
