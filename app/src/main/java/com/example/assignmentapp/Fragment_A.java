package com.example.assignmentapp;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 */
public class Fragment_A extends Fragment {
    EditText editText;
    View view;
    RecyclerView recyclerView;
    String data;
    int sharedValue;

    MyListnerInterface listenerInterface;

    public Fragment_A() {

    }

    public Fragment_A(String name) {
        // Required empty public constructor
        data = name;

    }

    public Fragment_A(Context context) {
        listenerInterface = (MyListnerInterface) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__a, container, false);
        List<String> list = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        editText = view.findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getContext(), ""+count, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                list.add(String.valueOf(s));
                adapter.updateList();
            }
        });

        return view;
    }


}