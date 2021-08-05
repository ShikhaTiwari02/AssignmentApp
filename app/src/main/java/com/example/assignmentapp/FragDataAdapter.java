package com.example.assignmentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FragDataAdapter extends RecyclerView.Adapter<FragDataHolder> {

    private List<String> fragDataList;
    FragDataListenerInterface fragDataListener;

    public FragDataAdapter(List<String> fragDataList, Context context) {
        this.fragDataList = fragDataList;
        this.fragDataListener = (FragDataListenerInterface) context;
    }

    @NonNull
    @Override
    public FragDataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragdata_cell, viewGroup, false);
        FragDataHolder fragDataHolder = new FragDataHolder(view);
        //return new FragDataHolder(view);
        return fragDataHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragDataHolder holder, int position) {
        holder.getTextView().setText(fragDataList.get(position));
        holder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragDataListener.shareData("fragment data test" + fragDataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return fragDataList.size();
    }

}
