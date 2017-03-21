package com.zll.xunyiwenyao;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	TextView activity_main_txtview = null;
	Button activity_main_button = null;
	int counter = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 初始化布局
		setContentView(R.layout.activity_main);
		// 获取控件
		activity_main_txtview = (TextView) findViewById(R.id.activity_main_txtview);
		activity_main_button = (Button) findViewById(R.id.activity_main_button);
		//绑定监听事件
		activity_main_button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.activity_main_button:
			counter++;
			activity_main_txtview.setText(String.valueOf(counter));
			break;

		default:
			break;
		}
	}
}
