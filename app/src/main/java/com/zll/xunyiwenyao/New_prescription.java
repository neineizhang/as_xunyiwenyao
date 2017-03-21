package com.zll.xunyiwenyao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zll.xunyiwenyao.util.CHScrollView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class New_prescription extends Activity {

	private Button add_drug,dialog_ok_btn;
	private View view_custom;
	private Context mContext;
	private AlertDialog alert = null;
	private AlertDialog.Builder builder = null;
	private ExpandableListView add_drugs_lv;
	private MyExpandableListViewAdapter2 adapter;
    private AutoCompleteTextView add_drugs_autv;
	private Map<String, List<String>> dataset = new HashMap<>();
	private String[] parentList = new String[] { "first", "second", "third" };
	private List<String> childrenList1 = new ArrayList<>();
	private List<String> childrenList2 = new ArrayList<>();
	private List<String> childrenList3 = new ArrayList<>();
	private static final String[] data = new String[]{
            "first", "second", "third", "forth", "fifth"
    };
	
	private ListView drugs_lv;
	public HorizontalScrollView mTouchView;
	protected List<CHScrollView> mHScrollViews =new ArrayList<CHScrollView>();  
	
	// static MultiValueMap<String, String> stringMultiValueMap = new
	// LinkedMultiValueMap<>();
	//
	// static{
	// stringMultiValueMap = new LinkedMultiValueMap<>();
	// // 添加Key为name的
	// stringMultiValueMap.add("感冒药", "感冒胶囊");
	// stringMultiValueMap.add("感冒药", "板蓝根");
	// stringMultiValueMap.add("感冒药", "39感冒灵");
	// stringMultiValueMap.add("感冒药", "感冒冲剂");
	// // 添加Key为domain的
	// stringMultiValueMap.add("心脏病", "速效救心丸");
	// stringMultiValueMap.add("心脏病", "心脏复苏丸");
	// }

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newprescription);

		add_drug = (Button) findViewById(R.id.add_drug);
        
		//设置listview的数据
		initViews();  
		// 初始化Builder
		builder = new AlertDialog.Builder(this);
		// final LayoutInflater inflater =
		// New_prescription.this.getLayoutInflater();
		view_custom = View.inflate(this, R.layout.add_drugs_dialog, null);
		// builder.setView(view_custom);
		// builder.setCancelable(true);
		add_drug.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				alert.show();
			}
		});

		// 添加药品的dialog的listview
		add_drugs_lv = (ExpandableListView) view_custom.findViewById(R.id.add_drugs_lv);
		add_drugs_autv = (AutoCompleteTextView) view_custom.findViewById(R.id.add_drugs_autv);
		
		
		  //初始化dialog上的确定按钮
		dialog_ok_btn = (Button) view_custom.findViewById(R.id.dialog_ok_btn);
		ArrayAdapter<String> autvadapter = new ArrayAdapter<String>(New_prescription.
                this, android.R.layout.simple_dropdown_item_1line, data);
        add_drugs_autv.setAdapter(autvadapter);
       
       
   		
		
		initialData();
		adapter = new MyExpandableListViewAdapter2();
		add_drugs_lv.setAdapter(adapter);
		add_drugs_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
	    
			
	  @Override
		public boolean onChildClick(ExpandableListView expandableListView, View view, int parentPos, int childPos,
					long l) {
		  add_drugs_autv.setText(dataset.get(parentList[parentPos]).get(childPos)); 
				Toast.makeText(New_prescription.this, dataset.get(parentList[parentPos]).get(childPos),
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});
		builder.setView(view_custom);
		alert = builder.create();
        
		
		dialog_ok_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				alert.dismiss();
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
    


	
	
	private class MyExpandableListViewAdapter2 extends BaseExpandableListAdapter {

		// 获得某个父项的某个子项
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

		// 获得某个父项
		@Override
		public Object getGroup(int parentPos) {
			return dataset.get(parentList[parentPos]);
		}

		// 获得某个父项的id
		@Override
		public long getGroupId(int parentPos) {
			return parentPos;
		}

		// 获得某个父项的某个子项的id
		@Override
		public long getChildId(int parentPos, int childPos) {
			return childPos;
		}

		// 按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
		@Override
		public boolean hasStableIds() {
			return false;
		}

		// 获得父项显示的view
		@Override
		public View getChildView(int parentPos, int childPos, boolean b, View view, ViewGroup viewGroup) {
			if (view == null) {
				LayoutInflater inflater = (LayoutInflater) New_prescription.this
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.add_drugs_dialog_item, null);
			}
			view.setTag(R.layout.add_drugs_dialog_list, parentPos);
			view.setTag(R.layout.add_drugs_dialog_item, childPos);
			TextView text = (TextView) view.findViewById(R.id.add_drugs_dialog_item);
			text.setText(dataset.get(parentList[parentPos]).get(childPos));
//			text.setOnClickListener(new View.OnClickListener() {
//				@Override
//				public void onClick(View view) {
//					Toast.makeText(New_prescription.this, "点到了内置的textview", Toast.LENGTH_SHORT).show();
//				}
//			});
			return view;
		}

		// 子项是否可选中，如果需要设置子项的点击事件，需要返回true
		@Override
		public boolean isChildSelectable(int i, int i1) {
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolderGroup groupHolder;
			if (convertView == null) {
				convertView = LayoutInflater.from(New_prescription.this).inflate(R.layout.item_exlist_group, parent, false);
				groupHolder = new ViewHolderGroup();
				groupHolder.tv_group_name = (TextView) convertView.findViewById(R.id.tv_group_name);
				convertView.setTag(groupHolder);
			} else {
				groupHolder = (ViewHolderGroup) convertView.getTag();
			}
			groupHolder.tv_group_name.setText("11111111111111");
			return convertView;
		}

		private class ViewHolderGroup {
			private TextView tv_group_name;
		}
	}

	private void initViews(){
		List<Map<String, String>> datas = new ArrayList<Map<String,String>>();  
        Map<String, String> data = null;  
        CHScrollView headerScroll = (CHScrollView) findViewById(R.id.item_scroll_title);
      //添加头滑动事件   
        mHScrollViews.add(headerScroll); 
        
        drugs_lv = (ListView) findViewById(R.id.drugs_lv);  
        //后期更换数据
        for(int i = 0; i < 5; i++) {  
            data = new HashMap<String, String>();  
            data.put("title", "Title_" + i);  
            data.put("data_" + 1, "Date_" + 1 + "_" +i );  
            data.put("data_" + 2, "Date_" + 2 + "_" +i );  
            data.put("data_" + 3, "Date_" + 3 + "_" +i );  
            data.put("data_" + 4, "Date_" + 4 + "_" +i );  
            data.put("data_" + 5, "Date_" + 5 + "_" +i );  
           
            datas.add(data);  
        }  
	    
	//
        SimpleAdapter adapter = new ScrollAdapter(this, datas, R.layout.scroll_item  
                , new String[] { "title", "data_1", "data_2", "data_3", "data_4", "data_5" }  
                , new int[] { R.id.item_title   
                            , R.id.item_data1  
                            , R.id.item_data2  
                            , R.id.item_data3  
                            , R.id.item_data4  
                            , R.id.item_data5   });  
                 drugs_lv.setAdapter(adapter);  
  
	}
	 public void addHViews(final CHScrollView hScrollView) {  
	        if(!mHScrollViews.isEmpty()) {  
	            int size = mHScrollViews.size();  
	            CHScrollView scrollView = mHScrollViews.get(size - 1);  
	            final int scrollX = scrollView.getScrollX();  
	            //第一次满屏后，向下滑动，有一条数据在开始时未加入  
	            if(scrollX != 0) {  
	                drugs_lv.post(new Runnable() {  
	                    @Override  
	                    public void run() {  
	                        //当listView刷新完成之后，把该条移动到最终位置  
	                        hScrollView.scrollTo(scrollX, 0);  
	                    }  
	                });  
	            }  
	        }  
	        mHScrollViews.add(hScrollView);  
	    } 
	 public void onScrollChanged(int l, int t, int oldl, int oldt){  
	        for(CHScrollView scrollView : mHScrollViews) {  
	            //防止重复滑动  
	            if(mTouchView != scrollView)  
	                scrollView.smoothScrollTo(l, t);  
	        }  
	    }  
	 
	      
	    class ScrollAdapter extends SimpleAdapter {  
	  
	        private List<? extends Map<String, ?>> datas;  
	        private int res;  
	        private String[] from;  
	        private int[] to;  
	        private Context context;  
	        public ScrollAdapter(Context context,  
	                List<? extends Map<String, ?>> data, int resource,  
	                String[] from, int[] to) {  
	            super(context, data, resource, from, to);  
	            this.context = context;  
	            this.datas = data;  
	            this.res = resource;  
	            this.from = from;  
	            this.to = to;  
	        }  
	          
	        @Override  
	        public View getView(int position, View convertView, ViewGroup parent) {  
	            View v = convertView;  
	            if(v == null) {  
	                v = LayoutInflater.from(context).inflate(res, null);  
	                //第一次初始化的时候装进来  
	                addHViews((CHScrollView) v.findViewById(R.id.item_scroll));  
	                View[] views = new View[to.length];  
	                for(int i = 0; i < to.length; i++) {  
	                    View tv = v.findViewById(to[i]);;  
	                    tv.setOnClickListener(clickListener);  
	                    views[i] = tv;  
	                }  
	                v.setTag(views);  
	            }  
	            View[] holders = (View[]) v.getTag();  
	            int len = holders.length;  
	            for(int i = 0 ; i < len; i++) {  
	                ((TextView)holders[i]).setText(this.datas.get(position).get(from[i]).toString());  
	            }  
	            return v;  
	        }  
	    }  
	      
	    //测试点击的事件   
	    protected View.OnClickListener clickListener = new View.OnClickListener() {  
	        @Override  
	        public void onClick(View v) {  
	            Toast.makeText(New_prescription.this, ((TextView)v).getText(), Toast.LENGTH_SHORT).show();  
	        }  
	    };  
	
}
