package bit.lizeqing.broadcastbestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forceOfflineButton.setOnClickListener {
            val intent = Intent("bit.lizeqing.broadcastbestpractice.OFFLINE_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }
    }

}