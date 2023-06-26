package com.example.slideswitch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

// ref:
//    https://stackoverflow.com/questions/21131158/android-switch-button-to-only-change-state-through-sliding -- slide-only switch
//    https://akira-watson.com/android/switchcompat-custom.html#2 -- custom thumb and track
//    https://dev.to/akshayranagujjar/how-to-make-custom-switch-in-android-5d1d
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchCompat slideSwitch = findViewById(R.id.slideSwitch);
        slideSwitch.setThumbResource(R.drawable.baseline_play_circle_48);

        TextView trackText = findViewById(R.id.trackText);
        trackText.setTextColor(Color.WHITE);
        if (slideSwitch != null) {
            // This combined with android:clickable="false"
            // makes this a slide only switch
            slideSwitch.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    slideSwitch.onTouchEvent(event);
                    return true;
                }
            });
            slideSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    //slideSwitch.setText(R.string.slideOn);
                    trackText.setText(R.string.slideOn);
                    trackText.setTextColor(Color.RED);
                    slideSwitch.setThumbResource(R.drawable.baseline_pause_circle_48);
                } else {
                    //slideSwitch.setText(R.string.slideOff);
                    trackText.setText(R.string.slideOff);
                    trackText.setTextColor(Color.WHITE);
                    slideSwitch.setThumbResource(R.drawable.baseline_play_circle_48);
                }
            });
        }
    }

}