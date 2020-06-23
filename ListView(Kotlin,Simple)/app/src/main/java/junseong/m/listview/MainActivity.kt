package junseong.m.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data1=Array(20){""}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(i in 0 until 20)
            data1[i]="문자열${i}"

        val adapter=ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,data1)
        list1.adapter=adapter
        list1.setOnItemClickListener(listener1)
    }
    val listener1=object:AdapterView.OnItemClickListener{
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when(p0?.id){
                R.id.list1 -> {
                    Toast.makeText(this@MainActivity,"${p2} 번째 클릭",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
