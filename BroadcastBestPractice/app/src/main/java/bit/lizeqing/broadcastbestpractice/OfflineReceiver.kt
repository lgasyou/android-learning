package bit.lizeqing.broadcastbestpractice

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class OfflineReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        AlertDialog
            .Builder(context)
            .setTitle("You are forced offline")
            .setMessage("You are forced offline")
            .setCancelable(false)
            .setPositiveButton("OK") {
                _, _ ->
                val i = Intent(context, LoginActivity::class.java)
                context.startActivity(i)
                ActivityCollector.finishAll()
            }
            .show()
    }

}