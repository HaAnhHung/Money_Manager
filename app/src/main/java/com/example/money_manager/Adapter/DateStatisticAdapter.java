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

public class DateStatisticAdapter extends RecyclerView.Adapter<DateStatisticAdapter.MyViewHolder> {

    //Context mContext;
    List<Statistic> statisticList;

    public DateStatisticAdapter(List<Statistic> statisticList) {
        //this.mContext = mContext;
        this.statisticList = statisticList;
    }

    @NonNull
    @Override
    public DateStatisticAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistic_today, parent, false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull DateStatisticAdapter.MyViewHolder holder, int position) {
//        holder.date_tv.setText(statisticList.get(position).getDate());
//        holder.total_tv.setText(statisticList.get(position).getTotal());
//        holder.income_tv.setText(statisticList.get(position).getIcome());
//        holder.expenses_tv.setText(statisticList.get(position).getExpenses());

        holder.date_tv.setText("25");
        holder.income_tv.setText("3000000");
        holder.expenses_tv.setText("2000000");

        int income = Integer.parseInt(holder.income_tv.getText().toString());
        int expenses = Integer.parseInt(holder.expenses_tv.getText().toString());

        int a = (int) (((float)income/(income+expenses))*100);
        int b = (int) (((float)expenses/(income+expenses))*100);

        holder.income_pgb.setProgress(a);
        holder.expenses_pgb.setProgress(b);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date_tv,income_tv, expenses_tv;
        ProgressBar income_pgb, expenses_pgb;
        CardView cardview_statistic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date_tv = itemView.findViewById(R.id.date_tv);
            income_tv = itemView.findViewById(R.id.income_tv);
            expenses_tv = itemView.findViewById(R.id.expenses_tv);
            income_pgb = itemView.findViewById(R.id.income_pgb);
            expenses_pgb = itemView.findViewById(R.id.expenses_pgb);
            cardview_statistic = itemView.findViewById(R.id.cardview_statistic);

        }
    }
}
