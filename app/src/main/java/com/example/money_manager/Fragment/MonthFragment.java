package com.example.money_manager.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.money_manager.Adapter.DateStatisticAdapter;
import com.example.money_manager.Adapter.MonthStatisticAdapter;
import com.example.money_manager.Model.Deal;
import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;

public class MonthFragment extends Fragment {

    private RecyclerView recyclerview_month;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Statistic> statisticList;

    private FirebaseFirestore fb;

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

//        Bundle bundle = getArguments();
//        String year = bundle.get("year").toString();
//
//        DocumentReference yearReference = fb.collection("Year").document(year);
//        yearReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                Log.d("hung", value.getData().toString());
//            }
//        });

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
