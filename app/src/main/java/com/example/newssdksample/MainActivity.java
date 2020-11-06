package com.example.newssdksample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tilismtech.tellotalk_news.listener.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
