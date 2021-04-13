package bit.lizeqing.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*
import java.net.URI

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        Log.v("FirstActivity", "task is $taskId")
//        button1.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }

//        button1.setOnClickListener {
//            val intent = Intent("bit.lizeqing.activitytest.ACTION_START")
//            // 仅当提供了所有的category才可以启动
//            intent.addCategory("bit.lizeqing.activitytest.MY_CATEGORY")
//            startActivity(intent)
//        }

//        button1.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)
//        }

//        button1.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("tel:10086")
//            startActivity(intent)
//        }
//
//        button1.setOnClickListener {
//            val intent = Intent("bit.lizeqing.activitytest.ACTION_START")
//            intent.addCategory("bit.lizeqing.activitytest.MY_CATEGORY")
//            intent.putExtra("extra_data", "Hello SecondActivity")
//            startActivity(intent)
//        }
//
//        button1.setOnClickListener {
//            val intent = Intent("bit.lizeqing.activitytest.ACTION_START")
//            intent.addCategory("bit.lizeqing.activitytest.MY_CATEGORY")
//            intent.putExtra("extra_data", "Hello SecondActivity")
//            startActivityForResult(intent, 1)
//        }

        button1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Log.v("FirstActivity", "Added")
            R.id.remove_item -> Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "data is $returnedData")
            }
        }
    }

}