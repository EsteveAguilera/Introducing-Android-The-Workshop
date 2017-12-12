package io.github.esteveaguilera.androidworkshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.github.esteveaguilera.androidworkshop.broadcastreceiver.BroadcastReceiverActivity;
import io.github.esteveaguilera.androidworkshop.intents.IntentsActivity;
import io.github.esteveaguilera.androidworkshop.notification.NotificationsActivity;
import io.github.esteveaguilera.androidworkshop.passdata.ActivityA;
import io.github.esteveaguilera.androidworkshop.photo.TakePhotoActivity;
import io.github.esteveaguilera.androidworkshop.sharedpreferences.SharedPreferencesActivity;

public class SelectTrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_training);

        findViewById(R.id.but_training_pass_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTrainingActivity.this, ActivityA.class));
            }
        });

        findViewById(R.id.but_training_shared_preferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTrainingActivity.this, SharedPreferencesActivity.class));
            }
        });

        findViewById(R.id.but_training_intents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTrainingActivity.this, IntentsActivity.class));
            }
        });

        findViewById(R.id.but_training_broadcast_receivers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTrainingActivity.this, BroadcastReceiverActivity.class));
            }
        });

        findViewById(R.id.but_training_take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTrainingActivity.this, TakePhotoActivity.class));
            }
        });

        findViewById(R.id.but_training_notifications).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTrainingActivity.this, NotificationsActivity.class));
            }
        });
    }
}
