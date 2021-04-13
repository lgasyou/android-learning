package bit.lizeqing.uiwidgettest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            val editText = findViewById<EditText>(R.id.editText)
            Log.d("MainActivity", "text: ${editText.text}")
            imageView.setImageResource(R.drawable.ic_launcher_foreground)

            // 圆圈格式的测试
//            progressBar.visibility = if (progressBar.visibility == View.VISIBLE) {
//                View.GONE
//            } else {
//                View.VISIBLE
//            }

            progressBar.progress += 10

            AlertDialog.Builder(this).apply {
                setTitle("This is Dialog")
                setMessage("Something important")
                setCancelable(false)
                setPositiveButton("OK") { _, _ -> }
                setNegativeButton("Cancel") { _, _ -> }
                show()
            }

//            val intent = Intent(this, SecondActivity::class.java)
//            val intent = Intent(this, ThirdActivity::class.java)
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }
    }
}