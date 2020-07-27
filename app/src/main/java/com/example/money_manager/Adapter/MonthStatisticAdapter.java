package com.example.money_manager.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;

import java.util.List;

public class MonthStatisticAdapter extends RecyclerView.Adapter<MonthStatisticAdapter.MyViewHolder> {

    List<Statistic> statisticList;

    public MonthStatisticAdapter(List<Statistic> statisticList) {
        this.statisticList = statisticList;
    }

    @NonNull
    @Override
    public MonthStatisticAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistic_month, parent, false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthStatisticAdapter.MyViewHolder holder, int position) {
        holder.month_tv.setText("7");
        holder.income_month_tv.setText("3000000");
        holder.expenses_month_tv.setText("2000000");

        int income = Integer.parseInt(holder.income_month_tv.getText().toString());
        int expenses = Integer.parseInt(holder.expenses_month_tv.getText().toString());

        int a = (int) (((float)income/(income+expenses))*100);
        int b = (int) (((float)expenses/(income+expenses))*100);

        holder.income_month_pgb.setProgress(a);
        holder.expenses_month_pgb.setProgress(b);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView month_tv, income_month_tv, expenses_month_tv;
        ProgressBar income_month_pgb, expenses_month_pgb;
        CardView statistic_month_cdv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            month_tv = itemView.findViewById(R.id.month_tv);
            income_month_tv = itemView.findViewById(R.id.income_month_tv);
            expenses_month_tv = itemView.findViewById(R.id.expenses_month_tv);
            income_month_pgb = itemView.findViewById(R.id.income_month_pgb);
            expenses_month_pgb = itemView.findViewById(R.id.expenses_month_pgb);
            statistic_month_cdv = itemView.findViewById(R.id.statistic_month_cdv);
        }
    }
}
