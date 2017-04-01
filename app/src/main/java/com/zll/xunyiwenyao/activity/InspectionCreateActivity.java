package com.zll.xunyiwenyao.activity;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.db.MyDBHelper;
import com.zll.xunyiwenyao.dbitem.Inspection;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import com.zll.xunyiwenyao.webservice.InspectionWebService;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class InspectionCreateActivity extends Activity implements onTitleBarClickListener{

	private  TopBarView topbar;
	private EditText ins_name, ins_content, ins_date, ins_comment;
	private EditText pat_name, pat_sexy, pat_age, pat_dia;
	private Button btn_save, btn_update;
//	private MyDBHelper mySqlHelper;
//	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_create);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		topbar.setClickListener(this);

//		MyDBHelper myDBHelper = new MyDBHelper(InspectionCreateActivity.this, "xywy.db",null, 1);
//		db = myDBHelper.getWritableDatabase();

		//获取控件信息
		ins_name = (EditText)findViewById(R.id.editText1);
		pat_name = (EditText)findViewById(R.id.name_text);
		pat_sexy = (EditText)findViewById(R.id.sexy_text);
		pat_age = (EditText)findViewById(R.id.age_text);
		pat_dia = (EditText)findViewById(R.id.clinical_diagnosis_text);
		ins_content = (EditText)findViewById(R.id.inspection_text);
		ins_date = (EditText)findViewById(R.id.date_text);
		ins_comment = (EditText)findViewById(R.id.comment_text);

		btn_save = (Button)findViewById(R.id.button_save);
		btn_update = (Button)findViewById(R.id.button_update);

		//保存按钮
		btn_save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addInspectionByWebService();

			}
		});
		btn_update.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				updateInspectionByWebService();

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
			inspection.setInspectionComment(ins_date.getText().toString());

			inspection.setPatientName(pat_name.getText().toString());
			inspection.setPatientSex(pat_sexy.getText().toString());
			inspection.setPatientAge(pat_age.getText().toString());
			inspection.setPatientDiag(pat_dia.getText().toString());

			inspection.setInspectionState("未提交");

			InspectionWebService.addInspection(inspection);

			Toast.makeText(InspectionCreateActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
//			finish();
		}
	}

	public void updateInspectionByWebService(){
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
			inspection.setPatientSex(pat_sexy.getText().toString());
			inspection.setPatientAge(pat_age.getText().toString());
			inspection.setPatientDiag(pat_dia.getText().toString());

			inspection.setInspectionState("已提交");

			InspectionWebService.addInspection(inspection);

			Toast.makeText(InspectionCreateActivity.this, "检查单已提交", Toast.LENGTH_SHORT).show();
			finish();
		}
	}
/*	public void addInspectionByDB(){
		if(ins_name.getText().toString().equals("")
				||pat_name.getText().toString().equals("")
				||ins_content.getText().toString().equals("")){
			Toast.makeText(InspectionCreateActivity.this, "您输入的信息不完整！",
					Toast.LENGTH_SHORT).show();
		}else{
			ContentValues values = new ContentValues();
			values.put("inspection_name",ins_name.toString());
			values.put("patient_name",pat_name.toString());
			values.put("patient_sex",pat_sexy.toString());
			values.put("patient_age",pat_age.toString());
			values.put("patient_diag",pat_dia.toString());
			values.put("inspection_text",ins_content.toString());
			values.put("inspection_date",ins_date.toString());
			values.put("inspection_comment",ins_comment.toString());
			values.put("inspection_state","未提交");
			db.insert("inspection",null,values);
			Toast.makeText(InspectionCreateActivity.this, "保存成功 to DB", Toast.LENGTH_SHORT).show();
			finish();
		}
	}*/

}
