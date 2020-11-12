package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;

import android.app.NativeActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    ImageButton ClickImageButton;
    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClickImageButton = (ImageButton) findViewById(R.id.imageButton);
        ClickImageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Resources res = MainActivity.this.getResources();
                NotificationCompat.Builder mBuilder =
                        (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(R.drawable.ic_stat_name)
                                .setContentTitle("Dourable")
                                .setContentText("Dourable is ringing, dourable is calling!!")
                                .setAutoCancel(true)
                                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_stat_name))
                                .setPriority(NotificationCompat.PRIORITY_HIGH)
                                .setDefaults(NotificationCompat.DEFAULT_LIGHTS)
                                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                                .setProgress(100, 0, true)
                                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
                Intent resultIntent = new Intent(MainActivity.this, MainActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
                stackBuilder.addParentStack(MainActivity.class);
                stackBuilder.addNextIntent(resultIntent);

                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
            }
        });
    }
}