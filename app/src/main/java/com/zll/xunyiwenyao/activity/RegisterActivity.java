package com.zll.xunyiwenyao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Utils;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.webservice.DoctorWebService;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by kejund on 17/4/5.
 */

public class RegisterActivity extends Activity implements TopBarView.onTitleBarClickListener {
    private  TopBarView topbar;
    private EditText user_name, real_name, passwrd, passwrd_verify, goodat, profile;

    private RadioGroup sex_rg, type_rg;
    private RadioButton sex_rb1, sex_rb2, type_rb1, type_rb2;
    int sex=Utils.SEX.MAN.ordinal();//0-男，1-女
    int type=Utils.DOCTOR_TYPE.DOCTOR.ordinal();//0-执业医生，1-审核医生

    private int head_image_id = R.drawable.image;
    private ImageView head_image;
    private int license_image_id = R.drawable.image2;
    private ImageView license_image;
    private final int CODE = 1;

    private Spinner spinner_title, spinner_hospital, spinner_department;
    String title, hospital, department;
    private String arrs_title[], arrs_hospital[], arrs_department[];

    private Button btn_commint, btn_cancel;


    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        topbar = (TopBarView)findViewById(R.id.topbar);
        topbar.setClickListener(this);

       //头像选择
        head_image = (ImageView) findViewById(R.id.headImage);
        head_image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //selectImage();
                chooseImage();
            }
        });

        //EditText
       user_name = (EditText)findViewById(R.id.user_name);
        real_name = (EditText)findViewById(R.id.real_name);
        passwrd = (EditText)findViewById(R.id.password_input);
        passwrd_verify = (EditText)findViewById(R.id.password_verify);
        goodat = (EditText)findViewById(R.id.goodat_text);
        profile = (EditText)findViewById(R.id.profile_text);

       //Spinner-title
        spinner_title = (Spinner)findViewById(R.id.spinner_title);
        arrs_title = getResources().getStringArray(R.array.listTitleArr);
         ArrayAdapter<String> arrsTitleAdapter = new ArrayAdapter<String>(
                RegisterActivity.this, android.R.layout.simple_list_item_1,arrs_title);
        spinner_title.setAdapter(arrsTitleAdapter);
        spinner_title.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                title = arrs_title[arg2];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
         //Spinner-hospial
        spinner_hospital = (Spinner)findViewById(R.id.spinner_hospital);
        arrs_hospital = getResources().getStringArray(R.array.listHospitalArr);
        ArrayAdapter<String> arrsHospitalAdapter = new ArrayAdapter<String>(
                RegisterActivity.this, android.R.layout.simple_list_item_1,arrs_hospital);
        spinner_hospital.setAdapter(arrsHospitalAdapter);
        spinner_hospital.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                hospital = arrs_hospital[arg2];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        //Spinner-department
        spinner_department = (Spinner)findViewById(R.id.spinner_department);
        arrs_department = getResources().getStringArray(R.array.listDepartmentArr);
        ArrayAdapter<String> arrsDepartmentAdapter = new ArrayAdapter<String>(
                RegisterActivity.this, android.R.layout.simple_list_item_1,arrs_department);
        spinner_department.setAdapter(arrsDepartmentAdapter);
        spinner_department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                department = arrs_department[arg2];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


        //Radio
        sex_rg = (RadioGroup)findViewById(R.id.sex_rg);
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

        type_rg = (RadioGroup)findViewById(R.id.type_rg);
        type_rb1 = (RadioButton)findViewById(R.id.type_rb1);
        type_rb2 = (RadioButton)findViewById(R.id.type_rb2);
        type_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                if (arg1 == type_rb1.getId()) {
                   type = Utils.DOCTOR_TYPE.DOCTOR.ordinal();
                } else {
                    type = Utils.DOCTOR_TYPE.ACCESSOR.ordinal();
                }
            }
        });

        //执业照片
        license_image = (ImageView) findViewById(R.id.licenseImage);
        license_image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //selectImage();
                chooseImage();
            }
        });

        //Button
        btn_commint = (Button)findViewById(R.id.button_commit);
        btn_cancel = (Button)findViewById(R.id.button_cancel);
        btn_commint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                doctorRegister();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
}
    @Override
    public void onBackClick() {
        RegisterActivity.this.finish();
    }
    @Override
    public void onRightClick() {
        Toast.makeText(RegisterActivity.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();

    }

    private void chooseImage() {
        // 选择相册
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, CODE);
    }

    public void doctorRegister(){
        if(user_name.getText().toString().equals("")
                ||real_name.getText().toString().equals("")
                ||passwrd.getText().toString().equals("")
                ||passwrd_verify.getText().toString().equals("")){
            Toast.makeText(RegisterActivity.this, "您输入的信息不完整！",
                    Toast.LENGTH_SHORT).show();
        }else if(passwrd.getText().toString().equals(passwrd_verify.getText().toString())){
            List<String> usernamelist = new ArrayList<String>();
            usernamelist= DoctorWebService.getAllUsername();
            int valid = 1;
            for(String name:usernamelist){
                if(name.equals(user_name.getText().toString()))
                    valid = 0;
            }
            if(valid==0){
                Toast.makeText(RegisterActivity.this, "用户名已经存在，请重新输入！",
                        Toast.LENGTH_SHORT).show();
            }else{
                Doctor doctor = new Doctor();
                doctor.setUsername(user_name.getText().toString());
                doctor.setSex(sex);
                doctor.setRealName(real_name.getText().toString());
                doctor.setPasswd(passwrd.getText().toString());
                doctor.setType(type);
                doctor.setHospital(hospital);
                doctor.setTitle(title);
                doctor.setDepartment(department);
                doctor.setGoodat(goodat.getText().toString());
                doctor.setProfile(profile.getText().toString());
                DoctorWebService.addDoctor(doctor);
                Toast.makeText(RegisterActivity.this, "注册成功！",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        }else{
            Toast.makeText(RegisterActivity.this, "两次输入的密码不一致！",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
