package bit.lizeqing.broadcastbestpractice

import android.app.Activity

object ActivityCollector {

    private val activities = mutableListOf<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (a in activities) {
            if (!a.isFinishing) {
                a.finish()
            }
        }
    }

}