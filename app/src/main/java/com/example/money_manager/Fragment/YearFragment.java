package com.example.money_manager.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.money_manager.Adapter.DateStatisticAdapter;
import com.example.money_manager.Adapter.YearStatisticAdapter;
import com.example.money_manager.Interface.IItemActionListener;
import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;

import java.util.ArrayList;
import java.util.List;

public class YearFragment extends Fragment {

    private RecyclerView recyclerview_month;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Statistic> statisticList;

    IItemActionListener itemActionListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_year, container, false);

        recyclerview_month = view.findViewById(R.id.recyclerview_year);
        recyclerview_month.setHasFixedSize(true);
        statisticList = new ArrayList<>();

        layoutManager = new LinearLayoutManager(getContext());
        recyclerview_month.setLayoutManager(layoutManager);

        adapter = new YearStatisticAdapter(statisticList);
        adapter.notifyDataSetChanged();
        recyclerview_month.setAdapter(adapter);

//        recyclerview_month.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
        
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //this.itemActionListener = (IItemActionListener) context;
    }
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
