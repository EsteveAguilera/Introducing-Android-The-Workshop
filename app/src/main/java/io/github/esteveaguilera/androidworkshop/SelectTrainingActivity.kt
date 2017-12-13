package io.github.esteveaguilera.androidworkshop

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import io.github.esteveaguilera.androidworkshop.broadcastreceiver.BroadcastReceiverActivity
import io.github.esteveaguilera.androidworkshop.intents.IntentsActivity
import io.github.esteveaguilera.androidworkshop.notification.NotificationsActivity
import io.github.esteveaguilera.androidworkshop.passdata.ActivityA
import io.github.esteveaguilera.androidworkshop.photo.TakePhotoActivity
import io.github.esteveaguilera.androidworkshop.sharedpreferences.SharedPreferencesActivity
import kotlinx.android.synthetic.main.activity_select_training.*

class SelectTrainingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_training)

        but_training_pass_data.setOnClickListener {
            startActivity(Intent(this@SelectTrainingActivity, ActivityA::class.java))
        }

        but_training_shared_preferences.setOnClickListener {
            startActivity(Intent(this@SelectTrainingActivity, SharedPreferencesActivity::class.java))
        }

        but_training_intents.setOnClickListener {
            startActivity(Intent(this@SelectTrainingActivity, IntentsActivity::class.java))
        }

        but_training_broadcast_receivers.setOnClickListener {
            startActivity(Intent(this@SelectTrainingActivity, BroadcastReceiverActivity::class.java))
        }

        but_training_take_photo.setOnClickListener {
            startActivity(Intent(this@SelectTrainingActivity, TakePhotoActivity::class.java))
        }

        but_training_notifications.setOnClickListener {
            startActivity(Intent(this@SelectTrainingActivity, NotificationsActivity::class.java))
        }
    }
}
