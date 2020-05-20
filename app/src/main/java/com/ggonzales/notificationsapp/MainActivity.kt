package com.ggonzales.notificationsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var notificationHelper : NotificationHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notificationHelper = NotificationHelper(this)

        channel1Button.setOnClickListener {
            notificationHelper!!.notify(1,
                                            notificationHelper!!.getNotification("First", inputEText.text.toString(), "first"))
        }
        channel2Button.setOnClickListener {
            notificationHelper!!.notify(2,
                                            notificationHelper!!.getNotification("Second", inputEText.text.toString(), "second"))
        }
        channel3Button.setOnClickListener {
            notificationHelper!!.notify(3,
                                            notificationHelper!!.getNotification("Third", inputEText.text.toString(), "third"))
        }

    }

}
