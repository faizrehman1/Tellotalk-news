package com.example.newssdksample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tilismtech.tellotalk_news.TelloApplication;

import org.json.JSONObject;

/**
 * Created by lpt-034 on 11/02/2019.
 */

public class MyFcmService extends FirebaseMessagingService {

    private static final String CONTENT_AVAILABLE_IM = "content-available-IM";
    private static final String CONTENT_AVAILABLE_CHANNEL = "content-available-Channel";
    public static final String NOTIFICATION_CHANNEL_ID = "4655";

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d("onNewToken", "token is : " + token);

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        /*
        Use the process given below to check if the notification received with the jobcode in
        the data call onMessageNotificationReceived() method of TelloApiClient.
         */

        Log.d("onMessageReceived", "Fcm message received is : " + remoteMessage.toString());
        if (remoteMessage.getData().size() > 0) {
            Log.d("onMessageReceived", "Data Payload: " + remoteMessage.getData().toString());
        }

        String s="{\n" +
                " \"profileId\": \"123\",\n" +
                " \"sdkNotification\": {\n" +
                "   \"news_id\": 3396,\n" +
                "   \"news_title\": \"Abu Dhabi Emirate\",\n" +
                "   \"news_description\": \"Abu Dhabi Emirate tech city\",\n" +
                "   \"news_url\": \"www.google.com\",\n" +
                "   \"category_id\": \"propakistani\",\n" +
                "   \"sub_category_id\": \"Sports\"\n" +
                " }\n" +
                "}";

        try {
            buildNotification(s);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void buildNotification(String s) {


        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject SDKnotification =  jsonObject.getJSONObject("sdkNotification");
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("sdk_payload",s);

            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            PendingIntent pendingIntent = PendingIntent.getActivity(TelloApplication.getInstance(), 0, i, PendingIntent.FLAG_CANCEL_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(TelloApplication.getInstance())
                    .setAutoCancel(true)
                    .setContentTitle(SDKnotification.optString("news_title"))
                    .setContentText(SDKnotification.optString("news_description"))
                    .setSmallIcon(R.drawable.me_bookmark_icon)
                    .setSound(alarmSound)
                    .setVibrate(new long[]{1000, 1000})
                    .setContentIntent(pendingIntent).setAutoCancel(true);

            NotificationManager manager = (NotificationManager) TelloApplication.getInstance().getSystemService(NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                        "abcd",
                        NotificationManager.IMPORTANCE_DEFAULT);
                channel.setDescription("abcd");
                manager.createNotificationChannel(channel);
                builder.setChannelId(NOTIFICATION_CHANNEL_ID);
            }

            manager.notify(1, builder.build());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
