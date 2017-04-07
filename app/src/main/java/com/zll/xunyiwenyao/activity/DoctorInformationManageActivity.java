package com.zll.xunyiwenyao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Utils;
import com.zll.xunyiwenyao.util.TopBarView;

import org.apache.http.cookie.CookieIdentityComparator;

/**
 * Created by kejund on 17/4/6.
 */

public class DoctorInformationManageActivity extends Activity implements TopBarView.onTitleBarClickListener{
    private  TopBarView topbar;
    private EditText user_name, real_name, passwrd, passwrd_verify, hospital, title, department, goodat, profile;
    private RadioGroup sex_rg, type_rg;
    private RadioButton sex_r1, sex_r2, type_r1, type_r2;
    private Button btn_update, btn_ok;
    private Doctor currDoctor = new Doctor();
    int sex = Utils.SEX.MAN.ordinal();
    int type = Utils.DOCTOR_TYPE.DOCTOR.ordinal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_information);
        topbar = (TopBarView) findViewById(R.id.topbar);
        topbar.setClickListener(this);

        currDoctor = Utils.LOGIN_DOCTOR;


        user_name = (EditText)findViewById(R.id.user_name);
        real_name = (EditText)findViewById(R.id.real_name);
        passwrd = (EditText)findViewById(R.id.password_input);
        passwrd_verify = (EditText)findViewById(R.id.password_verify);
        goodat = (EditText)findViewById(R.id.goodat_text);
        profile = (EditText)findViewById(R.id.profile_text);
        hospital = (EditText)findViewById(R.id.hospital_text);
        title = (EditText)findViewById(R.id.title_text);
        department = (EditText)findViewById(R.id.department_text);

        user_name.setText(currDoctor.getUsername());
        real_name.setText(currDoctor.getRealName());
        passwrd.setText(currDoctor.getPasswd());
        passwrd_verify.setText(currDoctor.getPasswd());
        goodat.setText(currDoctor.getGoodat());
        profile.setText(currDoctor.getProfile());
        hospital.setText(currDoctor.getHospital());
        title.setText(currDoctor.getTitle());
        department.setText(currDoctor.getDepartment());

        sex_rg = (RadioGroup)findViewById(R.id.sex_rg);
        sex_r1 = (RadioButton)findViewById(R.id.sex_rb1);
        sex_r2 = (RadioButton)findViewById(R.id.sex_rb2);
        sex=currDoctor.getSex();
        if (sex == Utils.SEX.MAN.ordinal()) {
            sex_r1.setChecked(true);
        } else {
            sex_r2.setChecked(true);
        }

        type_rg = (RadioGroup)findViewById(R.id.type_rg);
        type_r1 = (RadioButton)findViewById(R.id.type_rb1);
        type_r2 = (RadioButton)findViewById(R.id.type_rb2);
        type = currDoctor.getType();
        if(type==Utils.DOCTOR_TYPE.DOCTOR.ordinal())
            type_r1.setChecked(true);
        else
            type_r2.setChecked(true);

        btn_update = (Button)findViewById(R.id.button_update);
        btn_ok = (Button)findViewById(R.id.button_ok);

        //更新按钮
        btn_update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                passwrd.setEnabled(true);
                passwrd_verify.setEnabled(true);
                goodat.setEnabled(true);
                profile.setEnabled(true);
            }
        });
        //确定按钮
        btn_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(passwrd.getText().toString().equals(passwrd_verify.getText().toString())){
                    Utils.LOGIN_DOCTOR.setPasswd(passwrd.getText().toString());
                    Utils.LOGIN_DOCTOR.setGoodat(goodat.getText().toString());
                    Utils.LOGIN_DOCTOR.setProfile(profile.getText().toString());
                    Toast.makeText(DoctorInformationManageActivity.this, "用户信息修改成功！", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(DoctorInformationManageActivity.this, "两次输入的密码不一致！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    public void onBackClick() {
        DoctorInformationManageActivity.this.finish();
    }
    @Override
    public void onRightClick() {
        Toast.makeText(DoctorInformationManageActivity.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();

    }
}
