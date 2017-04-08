package com.example.raksa.fragmentbackstack;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button    buttonAddFragmentA
            , buttonAddFragmentB
            , buttonRemoveFragmentA
            , buttonRemoveFragmentB;

    FragmentManager fragmentManager = getFragmentManager();
    FragmentA fragmentA = new FragmentA();
    FragmentB fragmentB = new FragmentB();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddFragmentA = (Button) findViewById(R.id.buttonAddA);
        buttonAddFragmentB = (Button) findViewById(R.id.buttonAddB);
        buttonRemoveFragmentA = (Button) findViewById(R.id.buttonRemA);
        buttonRemoveFragmentB = (Button) findViewById(R.id.buttonRemB);



        buttonAddFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existFragment = fragmentManager.findFragmentByTag("FragmentA");
                if (existFragment==null){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.container,fragmentA,"FragmentA");
                    fragmentTransaction.addToBackStack("AddFragmentA");
                    fragmentTransaction.commit();

                }

            }
        });

        buttonRemoveFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existFragment = fragmentManager.findFragmentByTag("FragmentA");
                if (existFragment!=null){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(fragmentA);
                    fragmentTransaction.addToBackStack("RemoveFragmentA");
                    fragmentTransaction.commit();
                }
            }
        });

        buttonAddFragmentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existFragment = fragmentManager.findFragmentByTag("FragmentB");
                if (existFragment==null){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.container,fragmentB,"FragmentB");
                    fragmentTransaction.addToBackStack("AddFragmentB");
                    fragmentTransaction.commit();
                }
            }
        });

        buttonRemoveFragmentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existFragment = fragmentManager.findFragmentByTag("FragmentB");
                if (existFragment!=null){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(fragmentB);
                    fragmentTransaction.addToBackStack("RemoveFragmentB");
                    fragmentTransaction.commit();
                }
            }
        });

    }
}
