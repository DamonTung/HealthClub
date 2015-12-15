package utils;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.damontung.healthclub.R;

/**
 * Created by Administrator on 2015/11/11.
 */
public class MyTitle {
    private static Activity mActivity;
    public static void getTitleBar(Activity activity,String title){
        mActivity = activity;
        activity.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        //activity.setContentView(R.layout.title_main);
        TextView textView = (TextView) activity.findViewById(R.id.title);
        textView.setText(title);
        Button bkButton = (Button) activity.findViewById(R.id.backButton);
        bkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyEvent newEvent = new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_BACK);
            }
        });
    }

}
