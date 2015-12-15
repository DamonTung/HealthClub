package com.damontung.healthclub;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

import utils.MyTitle;


public class MainActivity extends Activity{
    private String[] listItemString = new String[]{"俯卧撑练习","卷腹练习","平板支撑","..."};
    private Object[] listImageItem = new Object[]{R.mipmap.fwc , R.mipmap.jf, R.mipmap.pbzc, R.mipmap.pbzc};
    private MyTitle myTitle = new MyTitle();
    private String titleString = "HealthClub";
    private String TAG = "DGZ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myTitle.getTitleBar(this,title);
 /*        View layoutTitle = getLayoutInflater().inflate(R.layout.title_main,null);
       final TextView title = (TextView) layoutTitle.findViewById(R.id.title_hc);
        title.setText(titleString);
        title.setVisibility(View.VISIBLE);

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), title.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Log.v(TAG, title.getText().toString());

        Button bkButton = (Button) layoutTitle.findViewById(R.id.backButton);
        bkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyEvent newEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK);
                Log.v(TAG,"bkButton onClick....");
            }
        });*/

        GridView gridView = (GridView) findViewById(R.id.gridview1);
        ArrayList<HashMap<String,Object>> listItem = new ArrayList<HashMap<String,Object>>();


        for(int i = 0; i < listItemString.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("ItemImage",listImageItem[i]);
            map.put("ItemText",listItemString[i]);
            listItem.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItem,R.layout.gridview_item,
                new String[]{"ItemImage","ItemText"},
                new int[]{R.id.itemimage,R.id.itemtext});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent();
                switch (position){
                    case 0 :

                        intent.setClass(getApplicationContext(),FWCActivity.class);
                        startActivity(intent);
                        break;
                    case 1:

                        intent.setClass(getApplicationContext(), JuanFuActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
                        Toast.makeText(getApplicationContext(), (String) item.get("ItemText"), Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });


    }
}