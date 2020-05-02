package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ReadDBActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_read_db);
        TextView titleview=findViewById(R.id.read_title);
        TextView contentview=findViewById(R.id.read_content);
        DBHelper helper=new DBHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select title, content from tb_memo order by _id desc limit 1",null);
        while(cursor.moveToNext()){
            titleview.setText(cursor.getString(0));
            contentview.setText(cursor.getString(1));
        }
        db.close();
    }
}