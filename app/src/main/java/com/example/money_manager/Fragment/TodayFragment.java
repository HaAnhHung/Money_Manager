package com.example.money_manager.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.money_manager.Adapter.TodayAdapter;
import com.example.money_manager.Model.Deal;
import com.example.money_manager.Model.DealToday;
import com.example.money_manager.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class TodayFragment extends Fragment {

    private RecyclerView recyclerview_today;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private FirebaseFirestore fb;
    private Calendar calendar;

    List<Deal> dealList;

    AddDealFragment addDealFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addDealFragment = new AddDealFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today, container, false);

        recyclerview_today = view.findViewById(R.id.recyclerview_today);
        recyclerview_today.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerview_today.setLayoutManager(layoutManager);

        fb = FirebaseFirestore.getInstance();

        calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        Log.d("hung", year);
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        Log.d("hung", month);
        String day = String.valueOf(calendar.get(Calendar.DATE));
        Log.d("hung", day);

        final CollectionReference mDealReference = fb.collection("Year")
                .document(year).collection("Month")
                .document(month).collection("Day")
                .document(day).collection("Deal");
       mDealReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
           @Override
           public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
               if (error != null) {
                   return;
               }

               List<Deal> dealList = new ArrayList<>();
               for (QueryDocumentSnapshot doc : value) {
                   dealList.add(doc.toObject(Deal.class));
               }

               adapter = new TodayAdapter(dealList);
               adapter.notifyDataSetChanged();
               recyclerview_today.setAdapter(adapter);
           }
       });
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if(task.isSuccessful()){
//                    dealList = new ArrayList<>();
//                    for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
//                        dealList.add(documentSnapshot.toObject(Deal.class));
//                    }
//
//                    adapter = new TodayAdapter(dealList);
//                    adapter.notifyDataSetChanged();
//                    recyclerview_today.setAdapter(adapter);
//                }
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

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
