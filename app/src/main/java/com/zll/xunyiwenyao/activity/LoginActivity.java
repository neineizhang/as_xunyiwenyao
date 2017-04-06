package com.zll.xunyiwenyao.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Review;
import com.zll.xunyiwenyao.dbitem.Utils;
import com.zll.xunyiwenyao.webservice.DoctorWebService;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.zll.xunyiwenyao.db.MyDBHelper;

public class LoginActivity extends Activity {

	private RadioGroup select_doctor;
	private Button login_entrylog;
	private EditText login_name, login_pwd;
	private Button btn_register;

	private MyDBHelper myDBHelper;
	private SQLiteDatabase db;


	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);


		select_doctor = (RadioGroup) findViewById(R.id.login_doctor_select);
		login_entrylog = (Button) findViewById(R.id.login_entrylog);
		login_name = (EditText) findViewById(R.id.login_name);
		login_pwd = (EditText) findViewById(R.id.login_pwd);
		btn_register = (Button)findViewById(R.id.register_button);
		//娉ㄥ唽
		btn_register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(i1);
			}
		});

		login_entrylog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				login();
			}
		});

	}//onCreate


	//以前的登陆函数
	public void login(){
		int doctor_id = select_doctor.getCheckedRadioButtonId();
		String name = login_name.getText().toString();
		String pwd = login_pwd.getText().toString();

		if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
			Toast.makeText(LoginActivity.this, "鐢ㄦ埛鍚嶆垨瀵嗙爜涓嶈兘涓虹┖", Toast.LENGTH_SHORT).show();
		} else {
			switch (doctor_id) {
				case R.id.login_doctor_select1: {

					Doctor islogin = DoctorWebService.isSuccessLogin(name, pwd, Utils.DOCTOR_TYPE.DOCTOR.ordinal());

					if (islogin != null) {
						Utils.LOGIN_DOCTOR = islogin;
						Intent i=new Intent(LoginActivity.this,MainActivity.class);
						startActivity(i);
						login_name.setText(null);
						login_pwd.setText(null);

					} else {
						Toast.makeText(LoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
						login_name.setText(null);
						login_pwd.setText(null);
					}

					break;
				}
				case R.id.login_doctor_select2: {

					Doctor islogin = DoctorWebService.isSuccessLogin(name, pwd, Utils.DOCTOR_TYPE.ACCESSOR.ordinal());

					if (islogin != null) {
						Utils.LOGIN_DOCTOR = islogin;
						Intent i=new Intent(LoginActivity.this,AccessorMainActivity.class);
						startActivity(i);
						login_name.setText(null);
						login_pwd.setText(null);

					} else {
						Toast.makeText(LoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
						login_name.setText(null);
						login_pwd.setText(null);
					}

					break;
				}

				default:
					Toast.makeText(LoginActivity.this, "Please select one type", Toast.LENGTH_SHORT).show();
					break;
			}
		}
	}
	// MD5鍔犲瘑
	public static String MD5(String string) {
		return encodeMD5String(string);
	}

	public static String encodeMD5String(String str) {
		return encode(str, "MD5");
	}

	private static String encode(String str, String method) {
		MessageDigest md = null;
		String dstr = null;
		try {
			md = MessageDigest.getInstance(method);
			md.update(str.getBytes());
			dstr = new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dstr;
	}

}
