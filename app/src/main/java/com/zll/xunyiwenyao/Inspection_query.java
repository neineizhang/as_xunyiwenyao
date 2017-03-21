package com.zll.xunyiwenyao;

import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Inspection_query extends Activity implements onTitleBarClickListener{
	private  TopBarView topbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_query);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		
		topbar.setClickListener(this);
	}
	@Override
	public void onBackClick() {
		Inspection_query.this.finish();		
	}
	@Override
	public void onRightClick() {
		Toast.makeText(Inspection_query.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}
	
	
	

}
