package com.example.runningup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by jack on 2016/4/13.
 */
public class FoundActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("This is Found Activity!");
        tv.setGravity(Gravity.CENTER);
        setContentView(tv);
    }
}
