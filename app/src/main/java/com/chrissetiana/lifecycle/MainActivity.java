package com.chrissetiana.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView lifeCycleDisplay;
    private static final String LIFECYCLE_CALLBACKS_TEXT = "callbacks";
    private static final ArrayList<String> lifeCycleCallbacks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifeCycleDisplay = findViewById(R.id.lifecycle_events_display);

        if(savedInstanceState != null) {
            if(savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT)) {
                String previousCallbacks = savedInstanceState.getString(LIFECYCLE_CALLBACKS_TEXT);
                lifeCycleDisplay.setText(previousCallbacks);
            }
        }

        for (int i = lifeCycleCallbacks.size() - 1; i >= 0; i--) {
            lifeCycleDisplay.append(lifeCycleCallbacks.get(i) + "\n");
        }

        lifeCycleCallbacks.clear();

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
        lifeCycleCallbacks.add(0, "onStop");
        logEvent("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logEvent("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifeCycleCallbacks.add(0, "onDestroy");
        logEvent("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logEvent("onSaveInstanceState");

        String lifeCycleEvents = lifeCycleDisplay.getText().toString();
        outState.putString(LIFECYCLE_CALLBACKS_TEXT, lifeCycleEvents);
    }

    private void logEvent(String event) {
        lifeCycleDisplay.append(event + "\n");
        Log.d("MainActivity", "Event: " + event);
    }

    public void resetEvent(View view) {
        lifeCycleDisplay.setText("Lifecycle callbacks:\n");
    }
}
