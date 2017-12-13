package io.github.esteveaguilera.androidworkshop.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.esteveaguilera.androidworkshop.MainActivity;
import io.github.esteveaguilera.androidworkshop.R;

public class NotificationsActivity extends AppCompatActivity {

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button butLaunchNotification = (Button) findViewById(R.id.but_launch_simple_notification);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        initNotificationChannels();

        butLaunchNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NotificationsActivity.this, MainActivity.class);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(NotificationsActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationsActivity.this, "default")
                                .setSmallIcon(R.drawable.ic_notification)
                                .setContentTitle("Notification title")
                                .setContentText("Notification text")
                                .addAction(R.drawable.ic_notification_go_to, "Go to", pendingIntent);

                int notificationId = 1;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(notificationId, builder.build());
            }
        });
    }

    public void initNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel channel = new NotificationChannel("default", "Channel", NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Channel description");
        notificationManager.createNotificationChannel(channel);
    }
}
