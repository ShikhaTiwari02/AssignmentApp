package com.example.assignmentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<String> localDataSet;
    MyListnerInterface listnerInterface;

    public MyRecyclerAdapter(List<String> localDataSet, Context context) {
        this.localDataSet = localDataSet;
        this.listnerInterface = (MyListnerInterface) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(localDataSet.get(position));
        viewHolder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listnerInterface.
                        shareToActivity("Successfully shared data to activity-values:" + localDataSet.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
    public void updateList(){
        this.notifyDataSetChanged();
    }
}
