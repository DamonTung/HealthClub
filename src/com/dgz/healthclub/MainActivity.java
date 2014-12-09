package com.dgz.healthclub;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	static int[] imageRes = { R.drawable.fwc, R.drawable.ywqz, R.drawable.pbzc,
			R.drawable.fj };
	static String[] itemStrings = { "俯卧撑练习", "仰卧起坐", "平板支撑", "腹肌撕裂者视频" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GridView gridView = (GridView) findViewById(R.id.homeGridView);
		ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 4; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("itemImage", imageRes[i]);
			hashMap.put("itemText", itemStrings[i]);
			itemList.add(hashMap);
		}

		SimpleAdapter sAdapter = new SimpleAdapter(this, itemList,
				R.layout.item, new String[] { "itemImage", "itemText" },
				new int[] { R.id.itemImage, R.id.itemText });
		gridView.setAdapter(sAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						itemStrings[arg2], Toast.LENGTH_SHORT).show();
				;
			}
		});

	}
}
