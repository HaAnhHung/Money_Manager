package com.example.money_manager.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.money_manager.Interface.IItemActionListener;
import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;

import java.util.List;

public class YearStatisticAdapter extends RecyclerView.Adapter<YearStatisticAdapter.MyViewHolder> {

    List<Statistic> statisticList;

    IItemActionListener itemActionListener;

    public YearStatisticAdapter(List<Statistic> statisticList) {
        this.statisticList = statisticList;
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
        holder.year_tv.setText("2020");
        holder.income_year_tv.setText("3000000");
        holder.expenses_year_tv.setText("2000000");

        int income = Integer.parseInt(holder.income_year_tv.getText().toString());
        int expenses = Integer.parseInt(holder.expenses_year_tv.getText().toString());

        int a = (int) (((float)income/(income+expenses))*100);
        int b = (int) (((float)expenses/(income+expenses))*100);

        holder.income_year_pgb.setProgress(a);
        holder.expenses_year_pgb.setProgress(b);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

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

        }
    }
}
