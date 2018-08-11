package com.chrissetiana.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lifeCycleDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifeCycleDisplay = findViewById(R.id.lifecycle_events_display);

        logEvent("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        logEvent("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        logEvent("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        logEvent("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        logEvent("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        logEvent("onRestart");
    }

    private void logEvent(String event) {
        lifeCycleDisplay.append(event + "\n");
        Log.d("MainActivity", "Event: " + event);
    }
}
