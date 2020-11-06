package com.example.newssdksample;

import android.app.Application;
import android.content.Context;

import com.tilismtech.tellotalk_news.TelloApplication;
import com.tilismtech.tellotalk_news.manager.TelloApiClient;

public class BaseController extends TelloApplication {

    private TelloApiClient telloApiClient;
    private static BaseController instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        TelloApiClient.Builder builder = new TelloApiClient.Builder()
                .accessKey("")
                .projectToken("")
                .notificationIcon(R.drawable.notification_bell);
        telloApiClient = builder.build();
    }


    @Override
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    public static BaseController getInstance() {
        return instance;
    }

    public TelloApiClient getTelloApiClient() {
        return telloApiClient;
    }
}