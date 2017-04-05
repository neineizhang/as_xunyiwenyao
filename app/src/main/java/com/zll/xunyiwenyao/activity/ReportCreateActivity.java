package com.zll.xunyiwenyao.activity;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ReportCreateActivity extends Activity implements onTitleBarClickListener{
	private  TopBarView topbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_create);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		
		topbar.setClickListener(this);
	}
	@Override
	public void onBackClick() {
		ReportCreateActivity.this.finish();
	
	}
	@Override
	public void onRightClick() {
		Toast.makeText(ReportCreateActivity.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}
}
