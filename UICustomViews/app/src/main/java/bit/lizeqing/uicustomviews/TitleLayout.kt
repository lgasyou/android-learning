package bit.lizeqing.uicustomviews

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_title.view.*

class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        // 为什么要给一个root？
        LayoutInflater.from(context).inflate(R.layout.layout_title, this)
        back.setOnClickListener {
            // 为什么上下文是Activity？
            val activity = context as Activity
            activity.finish()
        }
        edit.setOnClickListener {
            Toast.makeText(context, "You clicked Edit button", Toast.LENGTH_LONG).show()
        }
    }

}