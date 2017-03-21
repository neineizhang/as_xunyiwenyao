package com.zll.xunyiwenyao;

import java.util.ArrayList;

import com.zll.xunyiwenyao.adapter.MyBaseExpandableListAdapter;
import com.zll.xunyiwenyao.util.Group;
import com.zll.xunyiwenyao.util.Item;

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
import android.widget.Toast;

public class Precription_create extends Activity   {
	
	private AutoCompleteTextView prescription_create_search_text ;
	private Button prescription_create_search_button,prescription_create_return;
	private static final String[] data = new String[]{
            "xiaozhuzhu", "xiaogougou", "xiaomaomao", "xiaotutu", "dagougou"
    };
	private ArrayList<Group> gData = null;
    private ArrayList<ArrayList<Item>> iData = null;
    private ArrayList<Item> lData = null;
    private Context mContext;
    private ExpandableListView exlist_lol;
    private MyBaseExpandableListAdapter myAdapter = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prescription_create);
		prescription_create_search_text = (AutoCompleteTextView) findViewById(R.id.prescription_create_search_text);
		prescription_create_search_button = (Button) findViewById(R.id.prescription_create_search_button);
		prescription_create_return = (Button) findViewById(R.id.prescription_create_return);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(Precription_create. this, android.R.layout.simple_dropdown_item_1line, data);
	 
	        prescription_create_search_text.setAdapter(adapter);
	   mContext = Precription_create.this;
	   exlist_lol = (ExpandableListView) findViewById(R.id.exlist_lol);
	   //数据准备
       gData = new ArrayList<Group>();
       iData = new ArrayList<ArrayList<Item>>();
       
       gData.add(new Group("呼吸内科"));
       gData.add(new Group("消化内科"));
       gData.add(new Group("心血管科"));

       lData = new ArrayList<Item>();
       
        
     

       //AD组
       lData.add(new Item(R.drawable.item_picture,"剑圣"));
       lData.add(new Item(R.drawable.item_picture,"德莱文"));
       lData.add(new Item(R.drawable.item_picture,"男枪"));
       lData.add(new Item(R.drawable.item_picture,"韦鲁斯"));
       iData.add(lData);
       //AP组
       lData = new ArrayList<Item>();
       lData.add(new Item(R.drawable.item_picture, "提莫"));
       lData.add(new Item(R.drawable.item_picture,"安妮"));
       lData.add(new Item(R.drawable.item_picture, "天使"));
       lData.add(new Item(R.drawable.item_picture, "泽拉斯"));
       lData.add(new Item(R.drawable.item_picture,"狐狸"));
       iData.add(lData);
       //TANK组
       lData = new ArrayList<Item>();
       lData.add(new Item(R.drawable.item_picture, "诺手"));
       lData.add(new Item(R.drawable.item_picture, "德邦"));
       lData.add(new Item(R.drawable.item_picture, "奥拉夫"));
       lData.add(new Item(R.drawable.item_picture, "龙女"));
       lData.add(new Item(R.drawable.item_picture, "狗熊"));
       iData.add(lData);

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
       prescription_create_return.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new  Intent(Precription_create.this,maininterface.class);                                           
			startActivity(i);
		}
	});
       
       
       //为确定按钮添加监听事件
       prescription_create_search_button.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i2=new Intent(Precription_create.this,New_prescription.class);
			startActivity(i2);
		}
	});
	
	}

}
