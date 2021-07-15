package com.example.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragDataActivity extends AppCompatActivity implements FragDataListenerInterface {
    RecyclerView recyclerView;
    List<String> fragDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_data);
        recyclerView=findViewById(R.id.recycle_data);
        fragDataList=new ArrayList<>();
        fragDataList.add("abc");
        fragDataList.add("xyz");
        //set the layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Initialise Adapter
        FragDataAdapter fragDataAdapter=new FragDataAdapter(fragDataList, FragDataActivity.this);
        //set the adapter value in recyclerview
        recyclerView.setAdapter(fragDataAdapter);

    }

    @Override
    public void shareData(Object object) {
        Toast.makeText(this, (String)object, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(FragDataActivity.this, MainActivity.class);
        startActivity(intent);

    }
}