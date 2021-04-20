package bit.lizeqing.broadcastbestpractice

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    lateinit var offlineReceiver: OfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        offlineReceiver = OfflineReceiver()
        val filter = IntentFilter()
        filter.addAction("bit.lizeqing.broadcastbestpractice.OFFLINE_BROADCAST")
        registerReceiver(offlineReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(offlineReceiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

}