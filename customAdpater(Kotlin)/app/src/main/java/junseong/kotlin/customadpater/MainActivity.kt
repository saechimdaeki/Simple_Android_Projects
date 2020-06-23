package junseong.kotlin.customadpater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {
    val data1=Array(10){""}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for ( i in 0 until 10)
            data1[i]="데이터${i+1}"

        list.adapter=adapter1
    }
    val adapter1=object  :BaseAdapter()  {
        override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
            var rowView=p1
            if(rowView==null){
                rowView=layoutInflater.inflate(R.layout.row,null)
            }
            /*
            //항목 뷰 내부에 배치되어 있는 뷰들의 주소를 가져옴 첫번째 방법
            val tmptext=rowView?.findViewById<TextView>(R.id.rowtext)
            val btn1=rowView?.findViewById<Button>(R.id.button1)
            val btn2=rowView?.findViewById<Button>(R.id.button2)
            tmptext?.text=data1[position]

            btn1?.tag=position+1
            btn2?.tag=position+1


            btn1?.setOnClickListener{
                text1.text="첫번째 버튼누름 ${it.tag}"
            }
            btn2?.setOnClickListener{
                text1.text="두번째버튼누름 ${it.tag}"
            }

             */

            /* 두번째 방법 */
            rowView?.run{
                rowtext.text=data1[position]
                button1.tag=position+1
                button2.tag=position+1
                button1.setOnClickListener {
                 text1.text="첫번째 버튼을 누름 : ${it.tag}"
                }
                button2.setOnClickListener {
                    text1.text="두번째 버튼을 누름 :${it.tag}"
                }
            }
            return rowView!!
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
           return 0
        }

        override fun getCount(): Int {
            return data1.size
        }
    }
}
