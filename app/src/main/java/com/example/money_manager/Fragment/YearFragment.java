package com.example.money_manager.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.money_manager.Adapter.YearStatisticAdapter;
import com.example.money_manager.Interface.IDataChange;
import com.example.money_manager.Interface.IItemActionListener;
import com.example.money_manager.Model.InOut;
import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class YearFragment extends Fragment implements IItemActionListener{

    private RecyclerView recyclerview_year;
    private YearStatisticAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Statistic> statisticList;

    private IDataChange mDataChange;

    private IItemActionListener clickListener;

    private FirebaseFirestore fb;

    private final String key = "hung";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_year, container, false);

        recyclerview_year = view.findViewById(R.id.recyclerview_year);
        recyclerview_year.setHasFixedSize(true);
        statisticList = new ArrayList<>();

        fb = FirebaseFirestore.getInstance();

        layoutManager = new LinearLayoutManager(getContext());
        recyclerview_year.setLayoutManager(layoutManager);

        CollectionReference collectionReference = fb.collection("Year");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error!=null)
                    return;
                for(QueryDocumentSnapshot document : value){
                    Statistic statistic = new Statistic();
                    statistic.setDate(document.getId());
                    statistic.setIcome(document.get("chi").toString());
                    statistic.setExpenses(document.get("thu").toString());
                    statisticList.add(statistic);
                }
                adapter = new YearStatisticAdapter(statisticList, getContext());
                adapter.notifyDataSetChanged();
                adapter.setClickListener(YearFragment.this);
                recyclerview_year.setAdapter(adapter);
            }
        });
        
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void setmDataChange(IDataChange mDataChange) {
        this.mDataChange = mDataChange;
    }

    @Override
    public void onClick(View view, int position) {
        mDataChange.onDataChange();

        MonthFragment monthFragment = new MonthFragment();
        Bundle bundle = new Bundle();
        bundle.putString("year", statisticList.get(position).getDate());
        monthFragment.setArguments(bundle);
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
