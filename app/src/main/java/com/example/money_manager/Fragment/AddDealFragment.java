package com.example.money_manager.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.money_manager.Model.Deal;
import com.example.money_manager.Model.Statistic;
import com.example.money_manager.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class AddDealFragment extends Fragment {

    private Spinner group_spin;
    private List<Statistic> statisticList;
    private EditText money_edt, time_edt, id_edt, note_edt;
    private Button income_btn, expenses_btn;

    private String day;
    private String month;
    private String year;

//    public List<String> list = new ArrayList<>();

    FirebaseFirestore fb;

//    private OnFragmentInteractionListener mListener;
//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fb = FirebaseFirestore.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_deal, container, false);

        group_spin = view.findViewById(R.id.group_spin);
        money_edt = view.findViewById(R.id.money_edt);
        time_edt = view.findViewById(R.id.time_edt);
        id_edt = view.findViewById(R.id.id_edt);
        note_edt = view.findViewById(R.id.note_edt);
        income_btn = view.findViewById(R.id.income_btn);
        expenses_btn = view.findViewById(R.id.expenses_btn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.planets_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        group_spin.setAdapter(adapter);

//        final Deal deal = new Deal();
//        deal.setMoney(money_edt.getText().toString());
//        Log.i("hung",deal.getMoney());
//        deal.setNote(note_edt.getText().toString());
//        deal.setGroup(group_spin.getSelectedItem().toString());

        expenses_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String money = money_edt.getText().toString();
                String note = note_edt.getText().toString();
                String group = group_spin.getSelectedItem().toString();

                final Deal deal = new Deal(money, group, note,"Chi");

                String date[] = time_edt.getText().toString().split("/");
                day = date[0];
                month = date[1];
                year = date[2];

//                list.add(id_edt.getText().toString());

                DocumentReference idDeal = fb.collection("Year").document(year)
                        .collection("Month").document(month)
                        .collection("Day").document(day)
                        .collection("Deal").document(id_edt.getText().toString());
                idDeal.set(deal).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        return view;
    }

    private void addDeal(){

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
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
