package com.example.assignmentapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FragDataHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public FragDataHolder(@NonNull View itemView) {
        super(itemView);
        textView.findViewById(R.id.text_cell);
    }

    public TextView getTextView() {
        return textView;
    }
}
