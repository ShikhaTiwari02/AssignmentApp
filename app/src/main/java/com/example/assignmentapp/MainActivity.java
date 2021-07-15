package com.example.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MyListnerInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment_A fragment_a=new Fragment_A(MainActivity.this);

        useFragment(fragment_a);


        //fragment_a.shareData(200,"Mydata");
    }

   public void useFragment(Fragment fragment){
       //Create the manager for handling fragment
       FragmentManager fragmentManager= getSupportFragmentManager();
       // Notify the transaction to be initated for each call
       FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
       // call replace method to include fragment in layout specified
       fragmentTransaction.replace(R.id.container,fragment);
       // use to specify the back tracking of fragment
       fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
       // commit the transaction to be completed
       fragmentTransaction.commit();

   }

    @Override
    public void shareToActivity(Object object) {
        Fragment_B fragment_b=new Fragment_B();
        fragment_b.setData((String) object);

        useFragment(fragment_b);
    }
}