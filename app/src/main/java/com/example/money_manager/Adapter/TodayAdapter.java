package com.example.money_manager.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.money_manager.R;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.MyViewHolder> {

    public TodayAdapter() {
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
        holder.group_today_tv.setText("Ăn uống");
        holder.money_today_tv.setText("500000");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView group_today_tv, money_today_tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            group_today_tv = itemView.findViewById(R.id.group_today_tv);
            money_today_tv = itemView.findViewById(R.id.money_today_tv);
        }
    }
}
