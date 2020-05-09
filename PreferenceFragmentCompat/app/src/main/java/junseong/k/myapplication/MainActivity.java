package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String TARGET_SETTING_PAGE="target";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SettingPreferenceFragment settingPreferenceFragment=new SettingPreferenceFragment();
        Intent intent=getIntent();
        if(intent!=null){
            String rootkey=intent.getStringExtra(TARGET_SETTING_PAGE);
            if(rootkey!=null){
                Bundle args=new Bundle();
                args.putString(PreferenceFragmentCompat.ARG_PREFERENCE_ROOT,rootkey);
                settingPreferenceFragment.setArguments(args);
            }
        }
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content,settingPreferenceFragment,null).commit();
    }
}
