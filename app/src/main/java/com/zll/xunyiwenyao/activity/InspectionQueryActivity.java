package com.zll.xunyiwenyao.activity;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.adapter.InspectionAdapter;
import com.zll.xunyiwenyao.dbitem.Inspection;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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

		ins_adapter = new InspectionAdapter(InspectionQueryActivity.this);

        ins_listview = (ListView)findViewById(R.id.ins_listview);
        ins_listview.setAdapter(ins_adapter);
        ins_listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
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
		Toast.makeText(InspectionQueryActivity.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}



}
