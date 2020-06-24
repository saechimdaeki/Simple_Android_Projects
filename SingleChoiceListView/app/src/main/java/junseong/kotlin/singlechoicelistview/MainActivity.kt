package junseong.kotlin.singlechoicelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1= Array(10){""}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(i in 0 until 10)
            data1[i]="항목${i}"

        val adapter1=ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,data1)
        list.adapter=adapter1
        list.choiceMode=ListView.CHOICE_MODE_SINGLE
        list.setItemChecked(2,true)
        button.setOnClickListener {
            text1.text="${data1[list.checkedItemPosition]} 항목 선택되어있슴다"
        }
    }
}
