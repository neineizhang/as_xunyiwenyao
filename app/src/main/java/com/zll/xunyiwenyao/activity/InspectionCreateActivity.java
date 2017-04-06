package com.zll.xunyiwenyao.activity;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.db.MyDBHelper;
import com.zll.xunyiwenyao.dbitem.Inspection;
import com.zll.xunyiwenyao.dbitem.Utils;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import com.zll.xunyiwenyao.webservice.InspectionWebService;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Button;

import java.util.Calendar;

public class InspectionCreateActivity extends Activity implements onTitleBarClickListener{

	private  TopBarView topbar;
	private EditText ins_name, ins_content, ins_date, ins_comment;
	private EditText pat_name,  pat_age, pat_dia, doctor_name;
	private Button date_choose;
	private Button btn_save, btn_commit;
	private RadioGroup sex_rg;
	private RadioButton sex_rb1, sex_rb2;
	private Calendar calendar;
	private DatePickerDialog datePD;
	private int sex= Utils.SEX.MAN.ordinal();

	private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
							  int dayOfMonth) {
			// TODO Auto-generated method stub
			ins_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_create);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		topbar.setClickListener(this);


		//获取控件信息
		ins_name = (EditText)findViewById(R.id.editText1);
		pat_name = (EditText)findViewById(R.id.name_text);

		sex_rg = (RadioGroup) findViewById(R.id.sex_rg);
		sex_rb1 = (RadioButton)findViewById(R.id.sex_rb1);
		sex_rb2 = (RadioButton)findViewById(R.id.sex_rb2);
		sex_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (arg1 == sex_rb1.getId()) {
					sex = Utils.SEX.MAN.ordinal();
				} else {
					sex = Utils.SEX.WOMAN.ordinal();
				}
			}
		});

		pat_age = (EditText)findViewById(R.id.age_text);
		pat_dia = (EditText)findViewById(R.id.clinical_diagnosis_text);
		ins_content = (EditText)findViewById(R.id.inspection_text);
		doctor_name = (EditText)findViewById(R.id.doctor_text);
		//自动填写doctor姓名
		doctor_name.setText(Utils.LOGIN_DOCTOR.getRealName());

		ins_date = (EditText)findViewById(R.id.date_text);
		calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH);
		int day = calendar.get(calendar.DAY_OF_MONTH);
		datePD = new DatePickerDialog(InspectionCreateActivity.this,
				listener, year, month, day);
		date_choose = (Button)findViewById(R.id.date_choose);

		ins_comment = (EditText)findViewById(R.id.comment_text);

		btn_save = (Button)findViewById(R.id.button_save);
		btn_commit = (Button)findViewById(R.id.button_update);

		//日期选择按钮
		date_choose.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				datePD.show();
			}
		});
		//保存按钮
		btn_save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addInspectionByWebService();

			}
		});
		//更新按钮
		btn_commit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				commitInspectionByWebService();

			}
		});
	}
	//导航信息
	@Override
	public void onBackClick() {
		InspectionCreateActivity.this.finish();
	}
	@Override
	public void onRightClick() {
		Toast.makeText(InspectionCreateActivity.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}
	
	public void addInspectionByWebService(){
		if(ins_name.getText().toString().equals("")
				||pat_name.getText().toString().equals("")
				||ins_content.getText().toString().equals("")){
			Toast.makeText(InspectionCreateActivity.this, "您输入的信息不完整！",
					Toast.LENGTH_SHORT).show();
		}else{
			Inspection inspection = new Inspection();
			inspection.setInspectionName(ins_name.getText().toString());
			inspection.setInspectionText(ins_content.getText().toString());
			inspection.setInspectionDate(ins_date.getText().toString());
			inspection.setInspectionComment(ins_comment.getText().toString());

			inspection.setPatientName(pat_name.getText().toString());
			inspection.setPatientSex(sex);
			inspection.setPatientAge(pat_age.getText().toString());
			inspection.setPatientDiag(pat_dia.getText().toString());
			inspection.setDoctor(Utils.LOGIN_DOCTOR);


			inspection.setInspectionState(Utils.INSPECTION_STATUS.UNCOMMITED.ordinal());

			InspectionWebService.addInspection(inspection);

			Toast.makeText(InspectionCreateActivity.this, "检查单保存成功", Toast.LENGTH_SHORT).show();
			finish();
		}
	}

	public void commitInspectionByWebService(){
		if(ins_name.getText().toString().equals("")
				||pat_name.getText().toString().equals("")
				||ins_content.getText().toString().equals("")){
			Toast.makeText(InspectionCreateActivity.this, "您输入的信息不完整！",
					Toast.LENGTH_SHORT).show();
		}else{
			Inspection inspection = new Inspection();
			inspection.setInspectionName(ins_name.getText().toString());
			inspection.setInspectionText(ins_content.getText().toString());
			inspection.setInspectionDate(ins_date.getText().toString());
			inspection.setInspectionComment(ins_date.getText().toString());

			inspection.setPatientName(pat_name.getText().toString());
			inspection.setPatientSex(sex);
			inspection.setPatientAge(pat_age.getText().toString());
			inspection.setPatientDiag(pat_dia.getText().toString());
			inspection.setDoctor(Utils.LOGIN_DOCTOR);

			inspection.setInspectionState(Utils.INSPECTION_STATUS.COMMITED.ordinal());

			InspectionWebService.addInspection(inspection);

			Toast.makeText(InspectionCreateActivity.this, "检查单已提交", Toast.LENGTH_SHORT).show();
			finish();
		}
	}

}
