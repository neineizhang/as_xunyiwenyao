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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private AutoCompleteTextView autotext;
    private ArrayAdapter arrayAdapter;
    private ImageView im_search;



    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_query);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		topbar.setClickListener(this);

//        //按姓名搜索
//        autotext =(AutoCompleteTextView)findViewById(R.id.search_edit);
//        List<String> pnamelist = new ArrayList<String>();
//        pnamelist = InspectionWebService.getAllPatientName();
//        arrayAdapter = new ArrayAdapter<String>(InspectionQueryActivity.this, android.R.layout.simple_list_item_1,pnamelist);
//        autotext.setAdapter(arrayAdapter);
//        ImageView search = (ImageView) findViewById(R.id.image_search);
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // TODO Auto-generated method stub
//                inspectionList = InspectionWebService.getInspectionByPatientName(autotext.getText().toString());
//                if(inspectionList.size()!=0){
//                    ins_adapter.notifyDataSetChanged();
//                    Toast.makeText(InspectionQueryActivity.this, "查询结果如表所示",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(InspectionQueryActivity.this, "不存在满足条件的查询结果！",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        inspectionList = InspectionWebService.getAllInspection();
        ins_adapter = new InspectionAdapter(inspectionList, InspectionQueryActivity.this);
        ins_listview = (ListView)findViewById(R.id.ins_listview);
        ins_listview.setAdapter(ins_adapter);



        ins_listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                showInformationPage(arg2);

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

	public void showInformationPage(final int temp){
        Intent intent =new Intent(InspectionQueryActivity.this,InspectionCheckActivity.class);
        //用Bundle携带数据
        Bundle bundle=new Bundle();
        //传递name参数为tinyphp
        bundle.putInt("position",temp);
        intent.putExtras(bundle);
        startActivity(intent);
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
