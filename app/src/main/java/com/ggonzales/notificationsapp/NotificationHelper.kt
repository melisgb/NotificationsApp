package com.ggonzales.notificationsapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color

class NotificationHelper(context: Context) : ContextWrapper(context) {
    val notManager : NotificationManager by lazy{
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
    init{
        val channel1 = NotificationChannel(FIRST_CHANNEL, "First channel", NotificationManager.IMPORTANCE_DEFAULT)
        channel1.lightColor = Color.GREEN
        channel1.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        notManager.createNotificationChannel(channel1)

        val channel2 = NotificationChannel(SECOND_CHANNEL, "Second channel", NotificationManager.IMPORTANCE_DEFAULT)
        channel2.lightColor = Color.GREEN
        channel2.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        notManager.createNotificationChannel(channel2)

        val channel3 = NotificationChannel(THIRD_CHANNEL, "Third channel", NotificationManager.IMPORTANCE_DEFAULT)
        channel3.lightColor = Color.GREEN
        channel3.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        notManager.createNotificationChannel(channel3)
    }

    fun getNotification(title : String, body: String, channelID: String) : Notification.Builder {
        return Notification.Builder(applicationContext, channelID )
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.tictac)
            .setAutoCancel(true)
    }

    fun notify(id: Int, notification: Notification.Builder){
        notManager.notify(id, notification.build())
    }

    companion object {
        val FIRST_CHANNEL = "first"
        val SECOND_CHANNEL = "second"
        val THIRD_CHANNEL = "third"
    }

}