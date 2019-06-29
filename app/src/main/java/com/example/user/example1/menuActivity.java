package com.example.user.example1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onbackbuttonclicked(View v){
        Toast.makeText(getApplicationContext(), "돌아가기 버튼클릭", Toast.LENGTH_SHORT).show();
        finish();
    }
}
