package com.damontung.healthclub;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowAPILevel extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_apilevel);
        final TextView apiLevel = (TextView) findViewById(R.id.api_level);
        apiLevel.setText("show API Level");
        apiLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiLevel.setText("API Level: "+String.valueOf(Build.VERSION.SDK_INT));
            }
        });
    }
}
