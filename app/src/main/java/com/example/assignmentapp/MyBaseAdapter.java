package com.example.assignmentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {

    List<String> objectList;
    Context context;

    public MyBaseAdapter(List<String> objectList, Context context) {
        this.objectList = objectList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return objectList.size();
    }

    @Override
    public Object getItem(int position) {
        return objectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return objectList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.text_row_item, parent, false);
        TextView textView = view.findViewById(R.id.textView);

        String obj = objectList.get(position);
        textView.setText(obj);
        return view;
    }
}
