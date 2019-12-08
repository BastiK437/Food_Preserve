package com.example.android.foodpreserve;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

// https://www.androhub.com/android-alarmmanager/
// https://www.androhub.com/android-notification-bar/

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

public class AlarmManager extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "ALARM!! ALARM!!", Toast.LENGTH_SHORT).show();

        //Stop sound service to play sound for alarm
        context.startService(new Intent(context, AlarmSoundService.class));

        //This will send a notification message and show notification in notification tray
        ComponentName comp = new ComponentName(context.getPackageName(), AlarmNotificationService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));

    }

}
