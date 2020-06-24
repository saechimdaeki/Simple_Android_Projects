package junseong.kotlin.autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1= arrayOf("abcd","abca","abcb","abcc","bbaa","bbab","bcab","bdab")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apdater1=ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,data1)
        autotext.setAdapter(apdater1)
        button.setOnClickListener {
            text1.text=autotext.text
        }
       // autotext.setOnItemClickListener(listner1)
        autotext.setOnItemClickListener { parent, view, position, l ->
            text2.text="${data1[position]} 항목을 클릭스 "
        }
    }
    val listner1=object:AdapterView.OnItemClickListener{
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            text2.text="${data1[p2]} 항목을 클릭하였습니다"
        }
    }
}

