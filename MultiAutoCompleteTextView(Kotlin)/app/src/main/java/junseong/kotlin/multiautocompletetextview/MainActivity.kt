package junseong.kotlin.multiautocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data= arrayOf(
            "사과" , "사형", "사제","사젯","사수","사실"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter1=ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,data)


        multitext.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        multitext.setAdapter(adapter1)
        button.setOnClickListener {
            val strarray=multitext.text.split(",")
            text1.text=""
            for(str1 in strarray)
            {
                if(str1.trim() !="")
                {
                    text1.append("${str1.trim()}\n")
                }
            }
        }
        multitext.setOnItemClickListener { parent, view, position, l ->
            text2.text="${data[position]}항목 선택했다느능"
        }
    }
}
