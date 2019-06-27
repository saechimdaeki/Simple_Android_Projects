package com.example.user.example1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onbutton1clicked(View v){
        Toast.makeText(getApplicationContext(), "시작버튼이 눌렷어요", Toast.LENGTH_SHORT).show();
    }
}
