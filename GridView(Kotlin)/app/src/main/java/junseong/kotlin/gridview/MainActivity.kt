package junseong.kotlin.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data=Array(10){""}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(i in 0 until 10)
            data[i]="그리드 $i"

        val adapter1=ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
        gridview.adapter=adapter1
        //gridview.setOnItemClickListener(listner1)

        gridview.setOnItemClickListener { adapterView, view, i, l ->
            text.text="${data[i]} 항목을 클릭하엿습니다"
        }
    }

    val listner1= AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
        when(p0?.id){
            R.id.gridview-> {
                text.text="${data[p2]}항목을 클릭하였습니당"
            }
        }
    }
}
