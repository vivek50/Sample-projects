package com.example.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life_cycle);

        message("onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();

        message("onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        message("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        message("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        message("onRestart");

    }

    @Override
    protected void onStop() {
        super.onStop();

        message("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        message("onDestroy");
    }

    private void message(String message) {

        Toast.makeText(ActivityLifeCycle.this,message,Toast.LENGTH_SHORT).show();
    }
}