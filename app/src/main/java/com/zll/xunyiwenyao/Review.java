package com.zll.xunyiwenyao;


import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Review extends Activity implements onTitleBarClickListener{

	private  TopBarView topbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review);
		
		topbar = (TopBarView)findViewById(R.id.topbar);

		topbar.setClickListener(this);
		

	}
	@Override
	public void onBackClick() {
		Review.this.finish();		
	}
	@Override
	public void onRightClick() {
		Toast.makeText(Review.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}
	
	
	
	

	
	

}
