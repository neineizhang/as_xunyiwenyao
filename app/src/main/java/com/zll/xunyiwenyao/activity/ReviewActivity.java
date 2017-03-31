package com.zll.xunyiwenyao.activity;


import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Review;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import com.zll.xunyiwenyao.webservice.ReviewWebService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReviewActivity extends Activity implements onTitleBarClickListener{

	private  TopBarView topbar;
	private EditText review_name, review_content;
	private Button btn_add, btn_query;
	private TextView rResult;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review);
		
		topbar = (TopBarView)findViewById(R.id.topbar);

		topbar.setClickListener(this);

		review_name = (EditText)findViewById(R.id.review_name);
		review_content = (EditText)findViewById(R.id.review_content);
		btn_add = (Button) findViewById(R.id.button_add);
		btn_query = (Button)findViewById(R.id.button_query);
		rResult = (TextView)findViewById(R.id.query_result);

		btn_add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addReview();
			}
		});
		
		btn_query.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getReviews();
			}
		});
	}
	@Override
	public void onBackClick() {
		ReviewActivity.this.finish();
	}
	@Override
	public void onRightClick() {
		Toast.makeText(ReviewActivity.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}
	
	public void addReview(){
		Review item = new Review();
		item.setName(review_name.getText().toString());
		item.setContent(review_content.getText().toString());
		ReviewWebService.addReview(item);
		Toast.makeText(ReviewActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
	}

	public void getReviews(){
		List<Review> itemlist = new ArrayList<Review>();
		itemlist = ReviewWebService.getAllReview();
		String s="";

		if(itemlist.size()>0){
			System.out.println("查询结果为：");
			for(int i=0;i<itemlist.size();i++){
				Review item = itemlist.get(i);
				String name = item.getName();
				String content = item.getContent();
				s=s+"id:"+i+"    name: "+name+"    content:"+content+"\r\n";
			}
			rResult.setText(s);
		}else{
			rResult.setText("查询结果为空");
		}
	}

	
	

	
	

}
