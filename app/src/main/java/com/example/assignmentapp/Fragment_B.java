package com.example.assignmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment_B extends Fragment {



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_B() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment__b, container, false);
        // Inflate the layout for this fragment
        TextView textView = view.findViewById(R.id.textView);
        if (mParam1!=null)
            textView.setText(mParam1);
        return view;
    }

    public void setData(String object) {
        mParam1 = object;
    }
}