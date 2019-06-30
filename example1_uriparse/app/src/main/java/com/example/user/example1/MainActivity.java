package com.example.user.example1;

import android.content.Intent;
import android.net.Uri;
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
        Intent myintent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myintent);
    }
    public void onbutton2clicked(View v){
        Intent myintent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel: 010 -0000 - 0000"));
        startActivity(myintent);
    }
    public void onbutton3clicked(View v){
        Intent intent=new Intent(getApplicationContext(),menuActivity.class);
        startActivity(intent);
    }
}
