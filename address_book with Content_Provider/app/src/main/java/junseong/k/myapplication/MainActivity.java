package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button contactBtn;
    TextView nameView;
    TextView phoneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactBtn=findViewById(R.id.lab2_btn);
        nameView=findViewById(R.id.lab2_name);
        phoneView=findViewById(R.id.lab2_phone);

        contactBtn.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 100);
        }

    }

    @Override
    public void onClick(View v) {
        if(v==contactBtn){
            Intent intent=new Intent(Intent.ACTION_PICK);
            intent.setData(Uri.parse("content://com.android.contacts/data/phones"));
            startActivityForResult(intent, 10);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK) {
            String id = Uri.parse(data.getDataString()).getLastPathSegment();
            Cursor cursor = getContentResolver().query(ContactsContract.Data.CONTENT_URI,
                    new String[]{ContactsContract.Contacts.DISPLAY_NAME,
                            ContactsContract.CommonDataKinds.Phone.NUMBER},
                    ContactsContract.Data._ID + "=" + id, null, null);
            cursor.moveToFirst();
            String name = cursor.getString(0);
            String phone = cursor.getString(1);
            nameView.setText(name);
            phoneView.setText(phone);
        }

    }


}

