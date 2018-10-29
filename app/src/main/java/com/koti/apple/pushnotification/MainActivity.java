package com.koti.apple.pushnotification;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If a notification message is tapped, any data accompanying the notification
        // message is available in the intent extras. In this project the launcher
        // intent is fired when the notification is tapped, so any accompanying data would
        // be handled here. If you want a different intent fired, set the click_action
        // field of the notification message to the desired intent. The launcher intent
        // is used when no click_action is specified.
        //
        // Handle possible data accompanying notification message.
        /*try {
            if (getIntent().getExtras() != null) {

                for (String key : getIntent().getExtras().keySet()) {
                    String value = getIntent().getExtras().getString(key);

                    if (key.equals("AnotherActivity") && value.equals("True")) {
                        Intent intent = new Intent(this, AnotherActivity.class);
                        intent.putExtra("value", value);
                        startActivity(intent);
                        finish();
                    }

                }
            }

//            subscribeToPushService();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    private void subscribeToPushService() {
        FirebaseMessaging.getInstance().subscribeToTopic("news");

        Log.d("AndroidBash", "Subscribed");
        Toast.makeText(MainActivity.this, "Subscribed", Toast.LENGTH_SHORT).show();

        ///
        // Get token
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Received token
                        // D/MainActivity:  esK7XxlyYS4:APA91bHCGnHj_L7J4Bx6-Snt06IQGh-Q6WKzpyPZ4GtCSSfwZP2Aje_oeJSBy9BJzL_NJNd_raCMq_QaZvfB7nYmu5b-POLvYVMEO87QW0WSS8KUpJKFRW1JHeHjlmDhT6xAGQVTjzEl
                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, " "+token);
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
        ///
        /*String token = FirebaseInstanceId.getInstance().getToken();

        // Log and toast
        Log.d("AndroidBash >> ", " "+token);
        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();*/
    }
}
