package com.zll.xunyiwenyao.activity;


import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Review;
import com.zll.xunyiwenyao.dbitem.Utils;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import com.zll.xunyiwenyao.webservice.ReviewWebService;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import java.util.Calendar;

public class ReviewCreateActivity extends Activity implements onTitleBarClickListener{

	private  TopBarView topbar;
	private EditText review_name, drug_name, review_content, review_date, doctor_name, review_commet;
	private Button btn_commit, btn_drug_choose, btn_date_choose;
	private Calendar calendar;
	private DatePickerDialog datePD;

	private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
							  int dayOfMonth) {
			// TODO Auto-generated method stub
			review_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.review_create);
		
		topbar = (TopBarView)findViewById(R.id.topbar);

		topbar.setClickListener(this);

		review_name = (EditText)findViewById(R.id.review_name);
		drug_name = (EditText)findViewById(R.id.drug_text);
		review_content = (EditText)findViewById(R.id.review_content);
		review_date = (EditText)findViewById(R.id.date_text);
		review_commet =(EditText)findViewById(R.id.comment_text);
		doctor_name = (EditText)findViewById(R.id.doctor_text);

		btn_drug_choose = (Button)findViewById(R.id.drug_choose);
		btn_date_choose = (Button)findViewById(R.id.date_choose);
		btn_commit = (Button)findViewById(R.id.button_commit);

		//药品选择

		//自动填写医生
		doctor_name.setText(Utils.LOGIN_DOCTOR.getRealName().toString());
		//日期选择按钮
		calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH);
		int day = calendar.get(calendar.DAY_OF_MONTH);
		datePD = new DatePickerDialog(ReviewCreateActivity.this, listener, year, month, day);
		btn_date_choose.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				datePD.show();
			}
		});
		//提交按钮
		btn_commit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				commitReview();

			}
		});

	}
	public void commitReview(){
		if(review_name.getText().toString().equals("")
				||drug_name.getText().toString().equals("")
				||review_content.getText().toString().equals("")){
			Toast.makeText(ReviewCreateActivity.this, "您输入的信息不完整！",
					Toast.LENGTH_SHORT).show();
		}else{
			Review review = new Review();
			review.setName(review_name.getText().toString());
			review.setDrugName(review_name.getText().toString());
			review.setContent(review_content.getText().toString());
			review.setDate(review_date.getText().toString());
			review.setDoctor(Utils.LOGIN_DOCTOR);
			review.setComment(review_commet.getText().toString());
			ReviewWebService.addReview(review);
			Toast.makeText(ReviewCreateActivity.this, "药品评价提交成功！", Toast.LENGTH_SHORT).show();
			finish();
		}
	}
	@Override
	public void onBackClick() {
		ReviewCreateActivity.this.finish();
	}
	@Override
	public void onRightClick() {
		Toast.makeText(ReviewCreateActivity.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}
	

	
	

	
	

}
