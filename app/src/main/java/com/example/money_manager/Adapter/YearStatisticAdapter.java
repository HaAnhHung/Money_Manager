package com.example.money_manager.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.money_manager.Fragment.MonthFragment;
import com.example.money_manager.Interface.IDataChange;
import com.example.money_manager.Interface.IItemActionListener;
import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;
import com.google.common.primitives.UnsignedInts;

import java.util.List;

public class YearStatisticAdapter extends RecyclerView.Adapter<YearStatisticAdapter.MyViewHolder> {

    private List<Statistic> statisticList;
    private Context context;

    private IDataChange iDataChange;
    private IItemActionListener clickListener;

    public YearStatisticAdapter(List<Statistic> statisticList, Context context) {
        this.statisticList = statisticList;
        this.context = context;
    }

    @NonNull
    @Override
    public YearStatisticAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistic_year, parent, false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull YearStatisticAdapter.MyViewHolder holder, int position) {
        holder.year_tv.setText(statisticList.get(position).getDate());
        holder.income_year_tv.setText(statisticList.get(position).getIcome());
        holder.expenses_year_tv.setText(statisticList.get(position).getExpenses());

        long income = Integer.parseInt(holder.income_year_tv.getText().toString());
        long expenses = Integer.parseInt(holder.expenses_year_tv.getText().toString());
        int a = (int) (((float)income/(income+expenses))*100);
        int b = (int) (((float)expenses/(income+expenses))*100);

        holder.income_year_pgb.setProgress(a);
        holder.expenses_year_pgb.setProgress(b);
    }

    @Override
    public int getItemCount() {
        return statisticList.size();
    }

    public void setClickListener(IItemActionListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView year_tv, income_year_tv, expenses_year_tv;
        ProgressBar income_year_pgb, expenses_year_pgb;
        CardView statistic_year_cdv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            year_tv = itemView.findViewById(R.id.year_tv);
            income_year_tv = itemView.findViewById(R.id.income_year_tv);
            expenses_year_tv = itemView.findViewById(R.id.expenses_year_tv);
            income_year_pgb = itemView.findViewById(R.id.income_year_pgb);
            expenses_year_pgb = itemView.findViewById(R.id.expenses_year_pgb);
            statistic_year_cdv = itemView.findViewById(R.id.statistic_year_cdv);

            itemView.setOnClickListener(this);
            
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }
}

