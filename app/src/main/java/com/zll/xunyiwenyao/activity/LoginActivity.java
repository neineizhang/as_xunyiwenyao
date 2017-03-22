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

import java.math.BigInteger;
import java.security.MessageDigest;

//import com.zll.xunyiwenyao.db.MyDBHelper;

public class LoginActivity extends Activity {

	private RadioGroup select_doctor;
	private Button login_entrylog;
	private EditText login_name, login_pwd;
	private Button btn_register;
	//private MyDBHelper myDBHelper;
	private SQLiteDatabase db;


	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		//myDBHelper = new MyDBHelper(login.this,"xywy_db",null, 1);
//		db = myDBHelper.getReadableDatabase();

		select_doctor = (RadioGroup) findViewById(R.id.login_doctor_select);
		login_entrylog = (Button) findViewById(R.id.login_entrylog);
		login_name = (EditText) findViewById(R.id.login_name);
		login_pwd = (EditText) findViewById(R.id.login_pwd);
		//注册
//		btn_register.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				showMyDialog();
//			}
//		});

		login_entrylog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int doctor_id = select_doctor.getCheckedRadioButtonId();
				String name = login_name.getText().toString();
				String pwd = login_pwd.getText().toString();
				
				if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
					Toast.makeText(LoginActivity.this, "鐢ㄦ埛鍚嶆垨瀵嗙爜涓嶈兘涓虹┖", Toast.LENGTH_SHORT).show();
				} else {
					switch (doctor_id) {
					case R.id.login_doctor_select1: {
						if (name.equals("root") && pwd.equals("2222")) {
							
							Intent i=new Intent(LoginActivity.this,MainActivity.class);
							startActivity(i);
							login_name.setText(null);
							login_pwd.setText(null);
							
						} else if (!name.equals("root")) {
							Toast.makeText(LoginActivity.this, "涓嶅瓨鍦ㄨ鐢ㄦ埛", Toast.LENGTH_SHORT).show();
							login_name.setText(null);
							login_pwd.setText(null);
						} else {
							Toast.makeText(LoginActivity.this, "瀵嗙爜閿欒", Toast.LENGTH_SHORT).show();
						
							login_pwd.setText(null);
						}
						break;
					}
					case R.id.login_doctor_select2: {
						if (name.equals("admin") && pwd.equals("1234")) {
							
							Intent i=new Intent(LoginActivity.this,MainActivity.class);
							startActivity(i);
							login_name.setText(null);
							login_pwd.setText(null);
							
							
						} else if (!name.equals("root")) {
							Toast.makeText(LoginActivity.this, "涓嶅瓨鍦ㄨ鐢ㄦ埛", Toast.LENGTH_SHORT).show();
							login_name.setText(null);
							login_pwd.setText(null);
						} else {
							Toast.makeText(LoginActivity.this, "瀵嗙爜閿欒", Toast.LENGTH_SHORT).show();
					
							login_pwd.setText(null);
						}
						break;
					}

					default:
						Toast.makeText(LoginActivity.this, "璇烽�夋嫨鍖荤敓绫诲埆", Toast.LENGTH_SHORT).show();
						break;
					}
				}
			}
		});

	}//onCreate
	
	//注册
	public void showMyDialog() {
//		Builder builder = new Builder(login.this);
//		LayoutInflater inflater = LayoutInflater.from(login.this);
//		View view = inflater.inflate(R.layout.register_layout, null);
//		Button btn_confirm = (Button) view.findViewById(R.id.btn_confirm);
//		Button btn_back = (Button) view.findViewById(R.id.btn_back);
//		final EditText editUserName = (EditText) view
//				.findViewById(R.id.editText1);
//		final EditText editPswd = (EditText) view.findViewById(R.id.editText2);
//		final EditText editPswd_confirm = (EditText) view
//				.findViewById(R.id.editText3);
//		final AlertDialog dialog = builder.setTitle("学生信息注册").setView(view)
//				.create();
//
//		btn_confirm.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				if ((editPswd.getText().toString()).equals((editPswd_confirm
//						.getText().toString()))) {
//					Cursor cursor = db.rawQuery(
//							"select count(*) from user where username = '"
//									+ editUserName.getText().toString() + "'",
//							null);
//					cursor.moveToNext();
//					int count = cursor.getInt(0);
//					if (count == 0) {
//						ContentValues values = new ContentValues();
//						values.put("username", editUserName.getText()
//								.toString());
//						values.put("password", MD5(editPswd.getText().toString()));
//						db.insert("user", null, values);
//						dialog.dismiss();
//						Toast.makeText(login.this, "注册成功！",
//								Toast.LENGTH_SHORT).show();
//					} else {
//						Toast.makeText(login.this, "您注册的用户名已存在！",
//								Toast.LENGTH_SHORT).show();
//					}
//					cursor.close();
//				} else {
//					Toast.makeText(login.this, "您两次输入的密码不一样！",
//							Toast.LENGTH_SHORT).show();
//				}
//			}
//		});
//
//		dialog.show();
//		btn_back.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				dialog.dismiss();
//			}
//		});

	}
	// MD5加密
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
