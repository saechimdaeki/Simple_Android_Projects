package junseong.kotlin.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewlist=ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view1=layoutInflater.inflate(R.layout.view1,null)
        val view2=layoutInflater.inflate(R.layout.view2,null)
        val view3=layoutInflater.inflate(R.layout.view3,null)
        val view4=layoutInflater.inflate(R.layout.view1,null)
        val view5=layoutInflater.inflate(R.layout.view2,null)
        val view6=layoutInflater.inflate(R.layout.view3,null)

        viewlist.add(view1)
        viewlist.add(view2)
        viewlist.add(view3)
        viewlist.add(view4)
        viewlist.add(view5)
        viewlist.add(view6)

        viewpager1.adapter=adpater1
       // deprecated viewpager1.setOnPageChangeListener()
        viewpager1.addOnPageChangeListener(listener1)
    }
    // viewpager의 Adapter
    val adpater1= object : PagerAdapter() {

        //뷰의 전체갯수
        override fun getCount(): Int {
            return viewlist.size
        }

        //viewpager를 구성하기 위해 필요한 객체생성반환
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            viewpager1.addView(viewlist[position])
            return viewlist[position]
        }
        // instantiateItem 에서 반환한 뷰객체 사용할것인지 결정
        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view==obj
        }

        //사라지는 view 객체를 소멸시키는 메소드
        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            viewpager1.removeView(obj as View)
        }
    }
    val listener1 = object :ViewPager.OnPageChangeListener{
        //페이지 스크롤 끝났을때 호출.
        override fun onPageScrolled(position: Int,positionOffset: Float,positionOffsetPixels: Int) {
            textView.text="$position 번째 view가 나타났다능"
        }

        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageSelected(position: Int) {
        }
    }
}
