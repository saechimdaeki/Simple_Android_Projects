package junseong.k.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    FloatingActionButton fab;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=findViewById(R.id.relative);
        viewPager=findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Snackbar.make(relativeLayout,"Iam SnackBar",Snackbar.LENGTH_LONG).setAction("MoreAction", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).show();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments=new ArrayList<Fragment>();
        private String titles[]=new String[]{"TAB1","TAB2","TAB3"};
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(new OneFragment());
            fragments.add(new TwoFragment());
            fragments.add(new ThreeFragment());
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
        public CharSequence getPageTitle(int position){
            return titles[position];
        }

    }
}
