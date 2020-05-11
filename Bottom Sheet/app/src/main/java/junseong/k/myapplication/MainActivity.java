package junseong.k.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    CoordinatorLayout coordinatorLayout;
    BottomSheetBehavior<View> persistentBottomSheet;
    BottomSheetDialog modalBottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout=findViewById(R.id.coordinator);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(this);

        initPeristentBottomSheet();
    }

    private void initPeristentBottomSheet(){
        View bottomSheet=coordinatorLayout.findViewById(R.id.bottm_sheet);
        persistentBottomSheet= BottomSheetBehavior.from(bottomSheet);
    }

    @Override
    public void onClick(View v) {
        createDialog();
    }
    private void createDialog(){
        List<DataVO> list=new ArrayList<>();

        DataVO vo=new DataVO();
        vo.title="Keep";
        vo.image= ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_1, null);
        list.add(vo);

        vo=new DataVO();
        vo.title="Inbox";
        vo.image= ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_2, null);
        list.add(vo);

        vo=new DataVO();
        vo.title="Messanger";
        vo.image= ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_3, null);
        list.add(vo);

        vo=new DataVO();
        vo.title="Google+";
        vo.image= ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_4, null);
        list.add(vo);

        RecyclerViewAdpater adapter=new RecyclerViewAdpater(list);
        View view=getLayoutInflater().inflate(R.layout.modal_sheet, null);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        modalBottomSheet=new BottomSheetDialog(this);
        modalBottomSheet.setContentView(view);
        modalBottomSheet.show();
    }
}