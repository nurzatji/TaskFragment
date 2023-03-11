package com.example.taskfragment.servise

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.location.OnNmeaMessageListener
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.example.taskfragment.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.channels.Channel


public class PushNotificationService : FirebaseMessagingService() {

    @SuppressLint("MissingPermission")
    @RequiresApi(Build.VERSION_CODES.O)
    fun OnMessageReceived(remoteMessage: RemoteMessage){
        super.onMessageReceived(remoteMessage)
        Log.e("ololo","onMessageReceived" +remoteMessage.notification?.body)
        Log.e("ololo","onMessageReceived" +remoteMessage.notification?.title)

        val channel = NotificationChannel(CHANNEL_ID,
            "Heads Up Notifitation",NotificationManager.IMPORTANCE_HIGH )
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        val notification = Notification.Builder(this, CHANNEL_ID)
        notification.setSmallIcon(R.mipmap.ic_launcher)
        notification.setContentText(remoteMessage.notification?.body)
        notification.setContentTitle(remoteMessage.notification?.title)
        notification.setAutoCancel(true)

        NotificationManagerCompat.from(this).notify(1,notification.build())
    }
    companion object{
        const val CHANNEL_ID = "channel_task"
    }
}