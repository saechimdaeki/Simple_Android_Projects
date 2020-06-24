package junseong.kotlin.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {

    val imgRes= intArrayOf(
            R.drawable.imgflag1,
            R.drawable.imgflag2,
            R.drawable.imgflag3,
            R.drawable.imgflag4,
            R.drawable.imgflag5,
            R.drawable.imgflag6,
            R.drawable.imgflag7,
            R.drawable.imgflag8
            )
    val data1= arrayOf(
            "토고","프랑스","스위스","스페인","일본","독일","브라질","대한민국"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter1=RecycerAdapter()
        recycler.adapter=adapter1
        /* 리사이클러뷰 세가지방법 리사이클러뷰는 listview와 gridview의 통합형이므로*/

       //recycler.layoutManager=LinearLayoutManager(this)
        //recycler.layoutManager=GridLayoutManager(this,2)
        recycler.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        //recycler.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
    }
    //Recyclerview Adapter class
    inner class RecycerAdapter : RecyclerView.Adapter<RecycerAdapter.ViewHolderClass>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            //항목으로 사용할 view객체를 생성
            val itemView=layoutInflater.inflate(R.layout.row,null)
            val holder=ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)
            return holder
        }

        //viewholder를 통해 항목구성할때 항목내의 view객체에 데이터셋팅
        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowimageview.setImageResource(imgRes[position])
            holder.rowtext.text=data1[position]
        }

        override fun getItemCount(): Int {
            return imgRes.size
        }

        inner class ViewHolderClass(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
            val rowimageview=itemView.rowimage
                val rowtext=itemView.rowtext
            override fun onClick(v: View?) {
                text.text=data1[adapterPosition]
            }
        }

    }
}
