package com.example.grapeleafdisease;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.RequiresApi;

public class Splash_Screen extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(2200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent main = new Intent(Splash_Screen.this, MainActivity.class);
                    startActivity(main);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}