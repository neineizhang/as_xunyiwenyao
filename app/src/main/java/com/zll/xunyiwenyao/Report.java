package com.zll.xunyiwenyao;

import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Report extends Activity implements onTitleBarClickListener{
	private  TopBarView topbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		
		topbar.setClickListener(this);
	}
	@Override
	public void onBackClick() {
		Report.this.finish();
	
	}
	@Override
	public void onRightClick() {
		Toast.makeText(Report.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}
}
