package com.zll.xunyiwenyao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zll.xunyiwenyao.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PrescriptionTemplateActivity extends Activity {
	
	
	private  ExpandableListView template_exist_lol;
	private  AutoCompleteTextView prescription_template_search_text;
	private Map<String, List<String>> dataset = new HashMap<>();
    private String[] parentList = new String[]{"first", "second", "third"};
    private List<String> childrenList1 = new ArrayList<>();
    private List<String> childrenList2 = new ArrayList<>();
    private List<String> childrenList3 = new ArrayList<>();
    private static final String[] data = new String[]{
            "111", "222", "333", "233", "112"
    };  
    private Button prescription_template_search_button;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.prescription_template);
        
		prescription_template_search_button = (Button) findViewById(R.id.prescription_template_search_button);
		template_exist_lol = (ExpandableListView) findViewById(R.id.template_exist_lol);
		prescription_template_search_text = (AutoCompleteTextView) findViewById(R.id.prescription_template_search_text);
		initialData();  
		MyExpandableListViewAdapter3 adapter = new MyExpandableListViewAdapter3();  
		template_exist_lol.setAdapter(adapter);  
		template_exist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view,
                                        int parentPos, int childPos, long l) {
            	prescription_template_search_text.setText(dataset.get(parentList[parentPos]).get(childPos));
                Toast.makeText(PrescriptionTemplateActivity.this,
                        dataset.get(parentList[parentPos]).get(childPos), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
		
		ArrayAdapter<String> autvadapter = new ArrayAdapter<String>(PrescriptionTemplateActivity.
                this, android.R.layout.simple_dropdown_item_1line, data);
		prescription_template_search_text.setAdapter(autvadapter);
		
		prescription_template_search_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(PrescriptionTemplateActivity.this,PrescriptionTemplateMangeActivity.class);
				startActivity(i);
			}
		});
		

	}
      
		
	private void initialData() {
        childrenList1.add(parentList[0] + "-" + "first");
        childrenList1.add(parentList[0] + "-" + "second");
        childrenList1.add(parentList[0] + "-" + "third");
        childrenList2.add(parentList[1] + "-" + "first");
        childrenList2.add(parentList[1] + "-" + "second");
        childrenList2.add(parentList[1] + "-" + "third");
        childrenList3.add(parentList[2] + "-" + "first");
        childrenList3.add(parentList[2] + "-" + "second");
        childrenList3.add(parentList[2] + "-" + "third");
        dataset.put(parentList[0], childrenList1);
        dataset.put(parentList[1], childrenList2);
        dataset.put(parentList[2], childrenList3);
    }
	
	
	
    private class MyExpandableListViewAdapter3 extends BaseExpandableListAdapter {

	        //  获得某个父项的某个子项
	        @Override
	        public Object getChild(int parentPos, int childPos) {
	            return dataset.get(parentList[parentPos]).get(childPos);
	        }
	     // 获得父项的数量
			@Override
			public int getGroupCount() {
				return dataset.size();
				// return 0;
			}
			
			// 获得某个父项的子项数目
			@Override
			public int getChildrenCount(int parentPos) {
				return dataset.get(parentList[parentPos]).size();
			}
	       
	        //  获得某个父项
	        @Override
	        public Object getGroup(int parentPos) {
	            return dataset.get(parentList[parentPos]);
	        }

	        //  获得某个父项的id
	        @Override
	        public long getGroupId(int parentPos) {
	            return parentPos;
	        }

	        //  获得某个父项的某个子项的id
	        @Override
	        public long getChildId(int parentPos, int childPos) {
	            return childPos;
	        }

	        //  按函数的名字来理解应该是是否具有稳定的id，这个函数目前一直都是返回false，没有去改动过
	        @Override
	        public boolean hasStableIds() {
	            return false;
	        }

	        //  获得父项显示的view
	        @Override
	        public View getGroupView(int parentPos, boolean b, View view, ViewGroup viewGroup) {
	            if (view == null) {
	                LayoutInflater inflater = (LayoutInflater)PrescriptionTemplateActivity
	                        .this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                view = inflater.inflate(R.layout.prescription_template_lvgroup, null);
	            }
	            view.setTag(R.layout.prescription_template_lvgroup, parentPos);
	            view.setTag(R.layout.itemoftemplate, -1);
	            TextView text = (TextView) view.findViewById(R.id.template_tv_group_name);
	            text.setText(parentList[parentPos]);
	            return view;
	        }

	        //  获得子项显示的view
	        @Override
	        public View getChildView(int parentPos, int childPos, boolean b, View view, ViewGroup viewGroup) {
	            if (view == null) {
	                LayoutInflater inflater = (LayoutInflater) PrescriptionTemplateActivity
	                        .this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                view = inflater.inflate(R.layout.itemoftemplate, null);
	            }
	            view.setTag(R.layout.prescription_template_lvgroup, parentPos);
	            view.setTag(R.layout.itemoftemplate, childPos);
	            TextView text = (TextView) view.findViewById(R.id.template_tv_item_name);
	            text.setText(dataset.get(parentList[parentPos]).get(childPos));
	           
	              
	            return view;
	        }

	        //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
	        @Override
	        public boolean isChildSelectable(int i, int i1) {
	            return true;
	        }
	        private class ViewHolderGroup {
				private TextView template_tv_item_name;
			}

	    }
	}
