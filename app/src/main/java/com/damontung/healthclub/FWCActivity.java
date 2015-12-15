package com.damontung.healthclub;

import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Message;
import android.support.annotation.ColorRes;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.widget.Toast;

public class FWCActivity extends Activity {
    private static TextView[] fwcNumPlanTV = new TextView[5];
    private static int[] fwcNumId = new int[]{R.id.fwc_tv_1,R.id.fwc_tv_2,R.id.fwc_tv_3,R.id.fwc_tv_4,R.id.fwc_tv_5};;
    private int[] fwcNumPlanArray = new int[]{20,15,18,20,15};
    private TextView  fwcNum;//中间显示个数以及休息时间等数据
    private TextView  tv1;//顶部计划数据展示
    private String TAG = "DGZ";
    private static int iTag = 0;//控制顶部计划数组循环

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwc);

        init();
    }
    private void init(){
        Log.v(TAG,"FWCActivity ...   inti() ....");

        for(int i = 0; i < 5; i++){
            Log.v(TAG,"init" + fwcNumId[i]);

            fwcNumPlanTV[i] = getTextView(fwcNumId[i]);
            Log.v(TAG,"init ..." +fwcNumPlanTV[i]);
            fwcNumPlanTV[i].setText(String.valueOf(fwcNumPlanArray[i]));
        }


        fwcNum = (TextView) findViewById(R.id.fwc_tv_num);
        fwcNum.setVisibility(View.VISIBLE);
        fwcNum.setText("start");
        fwcNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fwcNum.getText().equals("start") && fwcNum.getTag().equals("0") && !fwcNum.getText().equals("0")) {
                    Message msg = new Message();
                    msg.what = 0;
                    msg.obj = "准备，开始！";
                    handler.sendMessage(msg);

                    countDownTimer.start();

                } else if (fwcNum.getText().equals("准备") && fwcNum.getTag().equals("0") && !fwcNum.getText().equals("0")) {
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                } else if (fwcNum.getTag().equals("1") && !fwcNum.getText().equals("0")) {
                    //initFwcNum();

                } else if (fwcNum.getTag().equals("2") && !fwcNum.getText().equals("0")) {
                    fwcNum.setText(Integer.parseInt(fwcNum.getText().toString()) - 1 + "");
                } else if (fwcNum.getText().equals("0")) {
                    Toast.makeText(getApplicationContext(),"休息45秒！！适当补充水分！！",Toast.LENGTH_SHORT).show();
                    rest.start();

                }
            }
        });
    }
    private void initFwcNum(){
        if(iTag == 5){
            iTag = 0;
            Message msg = new Message();
            msg.what = 2;
            handler.sendMessage(msg);
        }
        if(iTag >= 0 && iTag < 5){
            tv1 = getTextView(fwcNumId[iTag]);
            tv1.setBackground(getDrawable(R.drawable.textview_bg_yellow));
            if(iTag > 0)
                getTextView(fwcNumId[iTag-1]).setBackground(getDrawable(R.drawable.textview_bg_grey));
        }
        int number = fwcNumPlanArray[iTag];
        fwcNum.setText(number + "");
        fwcNum.setTag("2");

        Log.v(TAG,iTag+"...iTag...");
        iTag++;
    }

    private TextView getTextView(int id){
        return  (TextView)findViewById(id);
    }
    CountDownTimer countDownTimer = new CountDownTimer(3000,300) {
        @Override
        public void onTick(long millisUntilFinished) {
            try {
                fwcNum.setText(millisUntilFinished/1000 +"秒");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onFinish() {
            //fwcNum.setText("准备");
            Toast.makeText(getApplicationContext(),"GO！！",Toast.LENGTH_SHORT).show();
            initFwcNum();
        }
    };
    CountDownTimer rest = new CountDownTimer(45000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            try {
                fwcNum.setText(millisUntilFinished/1000 +"秒");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onFinish() {
            //fwcNum.setText("休息");
            fwcNum.setTag("1");
            initFwcNum();
        }
    };
    private void resetView(){
        fwcNum.setText("start");
        fwcNum.setTag("0");
        for(int i = 0; i < 5; i++){
            getTextView(fwcNumId[i]).setBackground(null);
        }
    }
    Handler handler = new Handler() {
       public  void handleMessage(Message msg){
            //super.handleMessage(msg);
           switch (msg.what){
               case 0:
                   Toast.makeText(getApplicationContext(),msg.obj.toString(),Toast.LENGTH_SHORT).show();

                   break;
               case 1:
                   fwcNum.setTag("1");

                   break;
               case 2:
                   Toast.makeText(getApplicationContext(),"该组计划已做完！请补充水分",Toast.LENGTH_SHORT).show();
                   resetView();
                   break;
           }
        }
    };

}
