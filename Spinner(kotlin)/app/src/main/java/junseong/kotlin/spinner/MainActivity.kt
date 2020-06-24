package junseong.kotlin.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data1=Array(10){""}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0 until 10)
            data1[i]="항목$i"

        //접혔을때 모습을 구성할 layout 설정
        val adapter1= ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,data1)

        //펼쳤을때 모습을 구성할 layout 설정
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapter1

        button.setOnClickListener {
            text.text="선택한 항목 ${data1[spinner.selectedItemPosition]}"
        }
        spinner.onItemSelectedListener=listner1
    }
    val listner1 = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when(p0?.id){
                R.id.spinner -> {
                    text.text="${data1[p2]}번째항목이 선택되었당"
                }
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }
    }
}
