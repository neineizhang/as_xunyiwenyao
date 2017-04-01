package com.zll.xunyiwenyao.activity;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.adapter.InspectionAdapter;
import com.zll.xunyiwenyao.dbitem.Inspection;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import com.zll.xunyiwenyao.webservice.InspectionWebService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;;


import java.util.ArrayList;
import java.util.List;

public class InspectionQueryActivity extends Activity implements onTitleBarClickListener{
	private  TopBarView topbar;
	private ListView ins_listview;
    private InspectionAdapter ins_adapter;
    private List<Inspection> inspectionList = new ArrayList<Inspection>();



    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_query);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		topbar.setClickListener(this);

        inspectionList = InspectionWebService.getAllInspection();
		ins_adapter = new InspectionAdapter(inspectionList, InspectionQueryActivity.this);
        ins_listview = (ListView)findViewById(R.id.ins_listview);
        ins_listview.setAdapter(ins_adapter);
        ins_listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                showInformation(arg2);//点击单挑记录，展现信息页面
                System.out.println(arg2);
            }
        });

	}
	@Override
	public void onBackClick() {
		InspectionQueryActivity.this.finish();
	}
	@Override
	public void onRightClick() {
        onResume();
		Toast.makeText(InspectionQueryActivity.this, "数据已更新", Toast.LENGTH_SHORT).show();
		
	}

    public void showInformation(final int temp){
        //创建dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(InspectionQueryActivity.this);
        LayoutInflater inflater = LayoutInflater
                .from(InspectionQueryActivity.this);
        View view = inflater.inflate(R.layout.inspection_manage, null);
        final AlertDialog dialog = builder.setTitle("检查单信息查看").setView(view)
                .create();
        //设置数据
        Button btn_update = (Button)view.findViewById(R.id.button_update);
        Button btn_ok = (Button)view.findViewById(R.id.button_ok);
        Button btn_cancel = (Button)view.findViewById(R.id.button_cancel);

        final EditText iname = (EditText)view.findViewById(R.id.editText1);
        final EditText pname = (EditText)view.findViewById(R.id.name_text);
        final EditText psex = (EditText)view.findViewById(R.id.sexy_text);
        final EditText page = (EditText)view.findViewById(R.id.age_text);
        final EditText pdiagnosis = (EditText)view.findViewById(R.id.clinical_diagnosis_text);
        final EditText icontent = (EditText)view.findViewById(R.id.inspection_text);
        final EditText idate = (EditText)view.findViewById(R.id.date_text);
        final EditText icomment = (EditText)view.findViewById(R.id.comment_text);
//        final String istate = "";

        iname.setText(inspectionList.get(temp).getInspectionName().toString());
        pname.setText(inspectionList.get(temp).getPatientName().toString());
        psex.setText(inspectionList.get(temp).getPatientSex().toString());
        page.setText(inspectionList.get(temp).getPatientAge().toString());
        pdiagnosis.setText(inspectionList.get(temp).getPatientDiag().toString());
        icontent.setText(inspectionList.get(temp).getInspectionText().toString());
        idate.setText(inspectionList.get(temp).getInspectionDate().toString());
        icomment.setText(inspectionList.get(temp).getInspectionComment().toString());

        final String istate = inspectionList.get(temp).getInspectionState().toString();

        //打开dialog
        dialog.show();

        //点击修改button
        btn_update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(istate.equals("未提交")){
                    pname.setEnabled(true);
                    psex.setEnabled(true);
                    page.setEnabled(true);
                    pdiagnosis.setEnabled(true);
                    icontent.setEnabled(true);
                    idate.setEnabled(true);
                    icomment.setEnabled(true);
                }else{
                    Toast.makeText(InspectionQueryActivity.this, "已提交的检查单不能修改！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //点击确定button
        btn_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Inspection newins = new Inspection();
                newins.setInspectionName(iname.getText().toString());
                newins.setPatientName(pname.getText().toString());
                newins.setPatientSex(psex.getText().toString());
                newins.setPatientAge(page.getText().toString());
                newins.setPatientDiag(pdiagnosis.getText().toString());
                newins.setInspectionText(icontent.getText().toString());
                newins.setInspectionDate(idate.getText().toString());
                newins.setInspectionComment(icomment.getText().toString());
                newins.setInspectionState(istate);

                InspectionWebService.updateInspectionByPosition(temp,newins);


                dialog.dismiss();
                Toast.makeText(InspectionQueryActivity.this, "修改成功，请点击右上角刷新！", Toast.LENGTH_SHORT).show();
            }
        });
        //点击取消button
        btn_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });


    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        inspectionList = new ArrayList<Inspection>();
        inspectionList=InspectionWebService.getAllInspection();
//        ins_listview.setAdapter(ins_adapter);
        ins_adapter.notifyDataSetChanged();
        super.onResume();
    }

}
