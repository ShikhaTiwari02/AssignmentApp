package com.example.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class SecondTaskActivity extends AppCompatActivity implements IncrementListener{
    TextView textView;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        textView=findViewById(R.id.fragText);

        ButtonIncrementFragment buttonIncrementFragment=new ButtonIncrementFragment();
        useFragment(buttonIncrementFragment);

    }
    public void useFragment(Fragment fragment){
        //Create the manager for handling fragment
        FragmentManager fragmentManager= getSupportFragmentManager();
        // Notify the transaction to be initated for each call
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        // call replace method to include fragment in layout specified
        fragmentTransaction.replace(R.id.fragcontainer,fragment);
        // use to specify the back tracking of fragment
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        // commit the transaction to be completed
        fragmentTransaction.commit();

    }

    @Override
    public void increment() {
        textView.setText(String.valueOf(count++));
    }
}