package bit.lizeqing.activitylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.startDialogActivity).setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.startNormalActivity).setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }

        if (savedInstanceState != null) {
            val data = savedInstanceState.getString("MainActivity")
            Log.d("MainActivity", "$data")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "Something needs to be saved"
        outState.putString("MainActivity", tempData)
        Log.d("MainActivity", "onSaveInstanceState")
    }
}