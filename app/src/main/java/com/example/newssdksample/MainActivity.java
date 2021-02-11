package com.example.newssdksample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tilismtech.tellotalk_news.entities.NotificationNewsObj;
import com.tilismtech.tellotalk_news.listener.NewSessionListener;
import com.tilismtech.tellotalk_news.listener.OnSuccessListener;
import com.tilismtech.tellotalk_news.manager.TelloApiClient;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements NewSessionListener {

    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseController.getInstance().getTelloApiClient().setUserInterface(true, TelloApiClient.ThemeType.CONVENTIONAL.name());

        if(getIntent().hasExtra("sdk_payload")) {
            try {
                // Receive Payload from FCM notification
                // This method redirect you the news category and sub-category
                JSONObject js = new JSONObject(getIntent().getStringExtra("sdk_payload"));
//                MyApplication.getInstance().getTelloApiClient().setNotificationState(new NotificationNewsObj(
//                        js.getJSONObject("sdkNotification").optString("category_id"),
//                        js.getJSONObject("sdkNotification").optString("sub_category_id"),
//                        js.optString("profileId")));

                BaseController.getInstance().getTelloApiClient().showNewsItem(MainActivity.this,new NotificationNewsObj(
                        js.getJSONObject("sdkNotification").optString("category_id"),
                        js.getJSONObject("sdkNotification").optString("sub_category_id"),
                        js.optString("profileId"),
                        js.getJSONObject("sdkNotification").optString("news_id"),
                        js.getJSONObject("sdkNotification").optString("news_title"),
                        js.getJSONObject("sdkNotification").optString("news_url"),
                        js.getJSONObject("sdkNotification").optString("channel_name")));
             //   BaseController.getInstance().getTelloApiClient().setNotificationState(new JSONObject(getIntent().getStringExtra("sdk_payload")));


            }catch (Exception e){
                e.printStackTrace();
            }

        }

        btn_register = (Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseController.getInstance().getTelloApiClient().registerUser(MainActivity.this, "test", new OnSuccessListener<Boolean>() {
                    @Override
                    public void onSuccess(Boolean object) {
                        if (object) {

                        }
                    }
                });
            }
        });

        BaseController.getInstance().getTelloApiClient().setNewSessionListener(MainActivity.this);

    }

    @Override
    public void onSessionExpired(boolean b) {
        Log.d("BooleanValue",""+b);
        Toast.makeText(MainActivity.this,""+b,Toast.LENGTH_SHORT).show();
    }
}
