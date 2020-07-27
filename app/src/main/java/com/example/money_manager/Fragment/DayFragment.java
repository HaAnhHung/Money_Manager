package com.example.money_manager.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.money_manager.Adapter.DateStatisticAdapter;
import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class DayFragment extends Fragment {

    private RecyclerView recyclerview_date;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Statistic> statisticList;

    FirebaseFirestore fb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day, container, false);

        recyclerview_date = view.findViewById(R.id.recyclerview_date);
        recyclerview_date.setHasFixedSize(true);
        statisticList = new ArrayList<>();

        layoutManager = new LinearLayoutManager(getContext());
        recyclerview_date.setLayoutManager(layoutManager);

        adapter = new DateStatisticAdapter(statisticList);
        adapter.notifyDataSetChanged();
        recyclerview_date.setAdapter(adapter);

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
