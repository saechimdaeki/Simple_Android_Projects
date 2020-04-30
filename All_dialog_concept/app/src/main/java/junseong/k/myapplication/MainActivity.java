package junseong.k.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button alertbtn;
    Button listbtn;
    Button datebtn;
    Button timebtn;
    Button custombtn;
    AlertDialog customdialog;
    AlertDialog listdialog;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertbtn=findViewById(R.id.btn_alert);
        listbtn=findViewById(R.id.btn_list);
        datebtn=findViewById(R.id.btn_date);
        timebtn=findViewById(R.id.btn_time);
        custombtn=findViewById(R.id.btn_custom);

        alertbtn.setOnClickListener(this);
        listbtn.setOnClickListener(this);
        datebtn.setOnClickListener(this);
        timebtn.setOnClickListener(this);
        custombtn.setOnClickListener(this);
    }
    private void ShowToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
    DialogInterface.OnClickListener dialogListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if(dialogInterface==customdialog &&which==DialogInterface.BUTTON_POSITIVE){
                ShowToast("custom dialog click 혹인");
            }else if(dialogInterface==listdialog){
                String[] datas=getResources().getStringArray(R.array.dialog_array);
                ShowToast(datas[which]+"선택햇다능");
            }else if(dialogInterface==alertDialog && which==DialogInterface.BUTTON_POSITIVE){
                ShowToast("ALERT DIALOG 클릭");
            }
        }
    };
    @Override
    public void onClick(View v){
        if(v==alertbtn){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_all_out_black_24dp);
            builder.setTitle("알림");
            builder.setMessage("정말 종료?");
            builder.setPositiveButton("ok",dialogListener);
            builder.setNegativeButton("no",null);
            alertDialog=builder.create();
            alertDialog.show();
        }else if(v==listbtn){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("알람벨소리");
            builder.setSingleChoiceItems(R.array.dialog_array,0,dialogListener);
            builder.setPositiveButton("확인",null);
            builder.setNegativeButton("취소",null);
            listdialog=builder.create();
            listdialog.show();
        }else if(v==datebtn){
            Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datedialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {
                    ShowToast(year+":"+(monthofyear+1)+":"+dayofmonth);
                }
            },year,month,day);
            datedialog.show();
        }else if(v==timebtn){
            Calendar c=Calendar.getInstance();
            int hour=c.get(Calendar.HOUR_OF_DAY);
            int minute=c.get(Calendar.MINUTE);
            TimePickerDialog timedialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourofday, int minute) {
                    ShowToast(hourofday+":"+minute);
                }
            },hour,minute,false);
            timedialog.show();
        }else if(v==custombtn){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.dialog_layout,null);
            builder.setView(view);
            builder.setPositiveButton("확인",dialogListener);
            builder.setNegativeButton("취소",null);
            customdialog=builder.create();
            customdialog.show();
        }
    }
}
