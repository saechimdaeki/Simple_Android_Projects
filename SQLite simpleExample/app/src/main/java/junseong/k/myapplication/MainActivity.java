package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText titleview,contentview;
    Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleview=findViewById(R.id.add_title);
        contentview=findViewById(R.id.add_content);
        addbtn=findViewById(R.id.add_btn);
        addbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String title=titleview.getText().toString();
        String content=contentview.getText().toString();
        DBHelper dbHelper=new DBHelper(this);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.execSQL("insert into tb_memo (title, content) values(?,?)",new String[]{title,content});
        db.close();
        Intent intent=new Intent(this,ReadDBActivity.class);
        startActivity(intent);
    }
}
