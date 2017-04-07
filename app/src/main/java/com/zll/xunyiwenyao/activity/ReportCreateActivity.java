package com.zll.xunyiwenyao.activity;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Report;
import com.zll.xunyiwenyao.dbitem.Utils;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import com.zll.xunyiwenyao.webservice.ReportWebService;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class ReportCreateActivity extends Activity implements onTitleBarClickListener{
	private  TopBarView topbar;
	private EditText report_name, feature, event_date,report_date, doctor_name, comment;
	private Button btn_event_choose, btn_report_choose, btn_commit;
	private Calendar calendar;
	private DatePickerDialog eventDatePD,reportDatePD;

	private DatePickerDialog.OnDateSetListener eventDatelistener = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
							  int dayOfMonth) {
			// TODO Auto-generated method stub
			event_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
		}
	};
	private DatePickerDialog.OnDateSetListener reportDatelistener = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
							  int dayOfMonth) {
			// TODO Auto-generated method stub
			report_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_create);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		
		topbar.setClickListener(this);

		report_name = (EditText)findViewById(R.id.name_text);
		feature = (EditText)findViewById(R.id.manifestation_text);
		event_date = (EditText)findViewById(R.id.event_date_text);
		report_date = (EditText)findViewById(R.id.report_date_text);
		doctor_name = (EditText)findViewById(R.id.doctor_text);
		comment=(EditText)findViewById(R.id.comment_text);

		btn_event_choose=(Button)findViewById(R.id.event_date_choose);
		btn_report_choose=(Button)findViewById(R.id.reprot_date_choose);
		btn_commit=(Button)findViewById(R.id.button_commit);

		//自动填写医生
		doctor_name.setText(Utils.LOGIN_DOCTOR.getRealName().toString());
		//日期选择按钮
		calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH);
		int day = calendar.get(calendar.DAY_OF_MONTH);
		eventDatePD = new DatePickerDialog(ReportCreateActivity.this, eventDatelistener, year, month, day);
		btn_event_choose.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				eventDatePD.show();
			}
		});

		reportDatePD = new DatePickerDialog(ReportCreateActivity.this, reportDatelistener, year, month, day);
		btn_report_choose.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				reportDatePD.show();
			}
		});
		//提交按钮
		btn_commit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				commitReport();

			}
		});

	}

	public void commitReport(){
		if(report_name.getText().toString().equals("")
				||feature.getText().toString().equals("")){
			Toast.makeText(ReportCreateActivity.this, "您输入的信息不完整！",
					Toast.LENGTH_SHORT).show();
		}else{
			Report report = new Report();
			report.setName(report_name.getText().toString());
			report.setFeature(feature.getText().toString());
			report.setEventDate(event_date.getText().toString());
			report.setReportDate(report_date.getText().toString());
			report.setDoctor(Utils.LOGIN_DOCTOR);
			report.setComment(comment.getText().toString());

			ReportWebService.addReport(report);
			Toast.makeText(ReportCreateActivity.this, "药品不良反应报告提交成功！", Toast.LENGTH_SHORT).show();
			finish();
		}
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
