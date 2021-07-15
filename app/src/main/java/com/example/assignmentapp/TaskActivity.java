package com.example.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity implements MyListnerInterface {
    RecyclerView recyclerView;
    List<String> tasklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        recyclerView=findViewById(R.id.recycler_View);
        tasklist = new ArrayList<>();
        tasklist.add("Shikha");
        tasklist.add("Santhosh");
        //set the layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Initialise Adapter
        MyRecyclerAdapter adapter=new MyRecyclerAdapter(tasklist,TaskActivity.this);
        //set the adapter value in recyclerview
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void shareToActivity(Object object) {
        Toast.makeText(this, (String) object, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(TaskActivity.this, SecondTaskActivity.class);
        startActivity(intent);
    }
}