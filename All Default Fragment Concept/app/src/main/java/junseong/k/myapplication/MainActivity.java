package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;
    Button btn3;
    FragmentManager manager;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.main_btn1);
        btn2=findViewById(R.id.main_btn2);
        btn3=findViewById(R.id.main_btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        manager=getSupportFragmentManager();
        oneFragment=new OneFragment();
        twoFragment=new TwoFragment();
        threeFragment=new ThreeFragment();

        FragmentTransaction tf=manager.beginTransaction();
        tf.addToBackStack(null);
        tf.add(R.id.main_container,oneFragment);
        tf.commit();
    }

    @Override
    public void onClick(View view) {
        if(view==btn1){
            if(!oneFragment.isVisible()){
                FragmentTransaction tf=manager.beginTransaction();
                tf.addToBackStack(null);
                tf.replace(R.id.main_container,oneFragment);
                tf.commit();
            }
        }else if(view==btn2){
            if(!twoFragment.isVisible())
                twoFragment.show(manager,null);
        }else if(view==btn3){
            if(!threeFragment.isVisible()){
                FragmentTransaction tf=manager.beginTransaction();
                tf.addToBackStack(null);
                tf.replace(R.id.main_container,threeFragment);
                tf.commit();
            }
        }
    }
}
