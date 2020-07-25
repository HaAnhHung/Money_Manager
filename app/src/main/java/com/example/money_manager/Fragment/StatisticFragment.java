package com.example.money_manager.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.money_manager.Adapter.StatisticAdapter;
import com.example.money_manager.R;
import com.google.android.material.tabs.TabLayout;

public class StatisticFragment extends Fragment {

    private StatisticAdapter adapter;
    private TabLayout tabLayout_statistic;
    private ViewPager viewPager_statistic;

//    private OnFragmentInteractionListener mListener;
//
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistic, container, false);

        tabLayout_statistic = view.findViewById(R.id.tabLayout_statistic);
        viewPager_statistic = view.findViewById(R.id.viewPager_statistic);

        adapter = new StatisticAdapter(getChildFragmentManager());
        adapter.addFragment(new DayFragment(), "Ngày");
        adapter.addFragment(new MonthFragment(), "Tháng");
        adapter.addFragment(new YearFragment(), "Năm");

        viewPager_statistic.setAdapter(adapter);
        tabLayout_statistic.setupWithViewPager(viewPager_statistic);

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
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
