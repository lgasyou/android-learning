package bit.lizeqing.activitytest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val data = intent.getStringExtra("extra_data")
        Log.v("SecondActivity", "data is $data")
        Log.v("SecondActivity", "task is $taskId")
//        button2.setOnClickListener {
//            val intent = Intent()
//            intent.putExtra("data_return", "Hello FirstActivity")
//            setResult(Activity.RESULT_OK, intent)
//            // TODO 不finish会咋？
//            finish()
//        }

        button2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello FirstActivity")
        setResult(Activity.RESULT_OK, intent)
        // TODO 不finish会咋？
        finish()
    }
}