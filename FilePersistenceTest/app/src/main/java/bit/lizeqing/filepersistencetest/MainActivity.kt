package bit.lizeqing.filepersistencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText.setText(load())
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputString = editText.text.toString()
        save(inputString)
    }

    private fun load(): String {
        try {
            val i = openFileInput("data")
            val r = BufferedReader(InputStreamReader(i))
            r.use {
                 return r.readText()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ""
    }

    private fun save(inputString: String) {
        try {
            val o = openFileOutput("data", Context.MODE_PRIVATE)
            val w = BufferedWriter(OutputStreamWriter(o))
            w.use {
                it.write(inputString)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}