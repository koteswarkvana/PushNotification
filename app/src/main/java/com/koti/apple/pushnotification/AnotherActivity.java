package com.koti.apple.pushnotification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class AnotherActivity extends AppCompatActivity {
    private static final String TAG = "AnotherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Log.e(TAG, "onCreate: >> ");
    }
}