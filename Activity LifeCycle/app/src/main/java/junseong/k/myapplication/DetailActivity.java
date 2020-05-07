package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    int count;
    TextView countVeiw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button btn=findViewById(R.id.detail_btn);
        countVeiw=findViewById(R.id.detail_count);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        count++;
        countVeiw.setText(String.valueOf(count));
    }
}