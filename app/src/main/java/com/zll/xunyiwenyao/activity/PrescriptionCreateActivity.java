package com.zll.xunyiwenyao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.adapter.MyBaseExpandableListAdapter;
import com.zll.xunyiwenyao.dbitem.PrescriptionTemplate;
import com.zll.xunyiwenyao.dbitem.Utils;
import com.zll.xunyiwenyao.util.Group;
import com.zll.xunyiwenyao.util.Item;
import com.zll.xunyiwenyao.webservice.PrescriptionTemplateWebService;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrescriptionCreateActivity extends Activity   {

	private AutoCompleteTextView prescription_create_search_text ;
	private Button prescription_create_search_button,prescription_create_return;
	private ArrayList<Group> gData = null;
    private ArrayList<ArrayList<Item>> iData = null;
    private ArrayList<Item> lData = null;
    private Context mContext;
    private ExpandableListView exlist_lol;
    private MyBaseExpandableListAdapter myAdapter = null;


    private static final String[] data = new String[]{
           "xiaozhuzhu", "xiaogougou", "xiaomaomao", "xiaotutu", "dagougou"
   };



    private void initData(){
        //数据准备
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Item>>();

        for(String item : Utils.DEPARTMENT_ARRAY) {
            gData.add(new Group(item));
            iData.add(new ArrayList<Item>());
        }

        List<PrescriptionTemplate> templatelt = PrescriptionTemplateWebService.getAllTemplate();
        for(PrescriptionTemplate item : templatelt){
            iData.get(item.getDepartment()).add(new Item(R.drawable.item_picture, item.getName()));
        }
    }

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prescription_create);

		prescription_create_search_text = (AutoCompleteTextView) findViewById(R.id.prescription_create_search_text);
		prescription_create_search_button = (Button) findViewById(R.id.prescription_create_search_button);
		prescription_create_return = (Button) findViewById(R.id.prescription_create_return);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(PrescriptionCreateActivity. this, android.R.layout.simple_dropdown_item_1line, data);

        prescription_create_search_text.setAdapter(adapter);
	    mContext = PrescriptionCreateActivity.this;
	    exlist_lol = (ExpandableListView) findViewById(R.id.exlist_lol);

        initData();
        myAdapter = new MyBaseExpandableListAdapter(gData,iData,mContext);
        exlist_lol.setAdapter(myAdapter);

       //为列表设置点击事件
       exlist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
           @Override
           public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

               prescription_create_search_text.setText(iData.get(groupPosition).get(childPosition).getiName());
               return true;
           }

       });

       //为返回按钮添加监听事件
       prescription_create_return.setOnClickListener(new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new  Intent(PrescriptionCreateActivity.this,MainActivity.class);
			startActivity(i);
		}
	});


       //为确定按钮添加监听事件
       prescription_create_search_button.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i2=new Intent(PrescriptionCreateActivity.this,PrescriptionCreateMainActivity.class);
			startActivity(i2);
		}
	});
	
	}

}
