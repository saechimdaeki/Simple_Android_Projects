package junseong.kotlin.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data1=Array(10){""}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(i in 0 until  10 step 1)
        {
            data1[i]="문자열 $i"
        }
        val adapter1=ArrayAdapter(this,R.layout.row, R.id.rowtext ,data1)
        list.adapter=adapter1
        list.setOnItemClickListener { adapterView, view, i, l ->
            text.text="${data1[i]}를 터치하였습니당"
        }
    }
}
