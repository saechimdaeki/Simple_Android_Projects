package com.github.shashank7200.snackbarexample;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);

        coordinatorLayout =(CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout,"Simple Snackbar",Snackbar.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout,"Snackbar with Action", Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(coordinatorLayout,"You clicked on Action Button",Snackbar.LENGTH_LONG).show();
                    }
                }).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar=Snackbar.make(coordinatorLayout,"Custom Snackbar", Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(coordinatorLayout,"You Clicked on Action Button",Snackbar.LENGTH_LONG).show();
                    }
                });
                //Set color of Action Bar
                snackbar.setActionTextColor(Color.YELLOW);

                //Set Color of Snackbar Text
                TextView v =(TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
                v.setTextColor(Color.GREEN);
                snackbar.show();
            }
        });
    }
}
