package junseong.kotlin.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val imgRes= intArrayOf(R.drawable.imgflag1,R.drawable.imgflag2,
    R.drawable.imgflag3,R.drawable.imgflag4,R.drawable.imgflag5,
    R.drawable.imgflag6,R.drawable.imgflag7,R.drawable.imgflag8)
    val data1= arrayOf("토고","프랑스","스위스","스페인","일본",
    "독일","브라질","대한민국")
    val data2= arrayOf("togo","france","swiss","spain","japan","german","brazil","korea")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datalist=ArrayList<HashMap<String,Any>>()
        for(i in imgRes.indices){
            val map=HashMap<String,Any>()
            map["img"]=imgRes[i]
            map["data1"]=data1[i]
            map["data2"]=data2[i]

            datalist.add(map)
        }
        val keys= arrayOf("img","data1","data2")
        val ids= intArrayOf(R.id.rowimage,R.id.rowtext1,R.id.rowtext2)
        val adapter1=SimpleAdapter(this,datalist,R.layout.row,keys,ids)
        list1.adapter=adapter1
        list1.setOnItemClickListener { parent, view, position, id ->
            text1.text="${data1[position]}항목을 터치하였습니다"
        }
    }
}
