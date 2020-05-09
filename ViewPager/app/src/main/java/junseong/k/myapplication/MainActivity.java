package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager=findViewById(R.id.pager);
        MypagerAdapter adapter=new MypagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }

    class MypagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragments;

        public MypagerAdapter(FragmentManager fm) {
            super(fm);
            fragments=new ArrayList<>();
            fragments.add(new OneFragment());
            fragments.add(new ThreeFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
