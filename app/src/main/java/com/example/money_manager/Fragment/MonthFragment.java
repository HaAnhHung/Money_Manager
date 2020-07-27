package com.example.money_manager.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.money_manager.Adapter.DateStatisticAdapter;
import com.example.money_manager.Adapter.MonthStatisticAdapter;
import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;

import java.util.ArrayList;
import java.util.List;

public class MonthFragment extends Fragment {

    private RecyclerView recyclerview_month;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Statistic> statisticList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_month, container, false);

        recyclerview_month = view.findViewById(R.id.recyclerview_month);
        recyclerview_month.setHasFixedSize(true);
        statisticList = new ArrayList<>();

        layoutManager = new LinearLayoutManager(getContext());
        recyclerview_month.setLayoutManager(layoutManager);

        adapter = new MonthStatisticAdapter(statisticList);
        adapter.notifyDataSetChanged();
        recyclerview_month.setAdapter(adapter);


        return view;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }


//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
