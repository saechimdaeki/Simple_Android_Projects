package junseong.m.chip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chip1.setOnClickListener {
            textView.text = "첫 번째 Chip을 클릭하였습니다\n"

            if(chip3.isChecked){
                textView.append("두 번째 Chip이 선택되었습니다\n")
            } else {
                textView.append("두 번째 Chip이 선택 되어 있지 않습니다\n")
            }

            if(chip4.isChecked){
                textView.append("세 번째 Chip이 선택되었습니다\n")
            } else {
                textView.append("세 번째 Chip이 선택 되어 있지 않습니다\n")
            }

            if(chip5.isChecked){
                textView.append("네 번째 Chip이 선택되었습니다\n")
            } else {
                textView.append("네 번째 Chip이 선택 되어 있지 않습니다\n")
            }

            when(chipGroup1.checkedChipId){
                R.id.chip6 ->{
                    textView.append("그룹 내의 첫 번째 Chip이 선택되어 있습니다\n")
                }
                R.id.chip7 ->{
                    textView.append("그룹 내의 두 번째 Chip이 선택되어 있습니다\n")
                }
                R.id.chip8 ->{
                    textView.append("그룹 내의 세 번째 Chip이 선택되어 있습니다\n")
                }
            }
        }

        chip4.setOnCloseIconClickListener {
            textView.text = "닫기 버튼을 눌렀습니다"
        }

        chip5.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked == true){
                textView.text = "네 번째 Chip이 체크 되었습니다"
            } else {
                textView.text = "네 번째 Chip이 체크 해제 되었습니다"
            }
        }
    }
}
