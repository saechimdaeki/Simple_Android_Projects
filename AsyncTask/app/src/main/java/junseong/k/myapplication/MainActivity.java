package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView startView;
    ImageView pauseView;
    TextView textView;

    boolean isFirst = true;

    MyAsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startView = (ImageView) findViewById(R.id.main_startBtn);
        pauseView = (ImageView) findViewById(R.id.main_pauseBtn);
        textView = (TextView) findViewById(R.id.main_textView);

        startView.setOnClickListener(this);
        pauseView.setOnClickListener(this);

        asyncTask = new MyAsyncTask();
    }

    @Override
    public void onClick(View view) {
        if(view==startView){
            if(isFirst){
                asyncTask.isRun=true;
                asyncTask.execute();
                isFirst=false;
            }else{
                asyncTask.isRun=true;
            }
        }else if(view==pauseView){
            asyncTask.isRun=false;
        }
    }
    class MyAsyncTask extends AsyncTask<Void,Integer,String>{
        boolean loopFlag=true;
        boolean isRun;
        @Override
        protected String doInBackground(Void... voids) {
            int count=10;
            while(loopFlag){
                SystemClock.sleep(1000);
                if(isRun){
                    count--;
                    publishProgress(count);
                    if(count==0){
                        loopFlag=false;
                    }
                }
            }
            return "FINISH!!!";
        }
        @Override
        protected void onProgressUpdate(Integer... values){
            textView.setText(String.valueOf(values[0]));
        }
        @Override
        protected void onPostExecute(String values){
            textView.setText(values);
        }
    }
}
