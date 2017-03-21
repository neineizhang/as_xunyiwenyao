package com.zll.xunyiwenyao;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zll.xunyiwenyao.util.CHScrollView2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class TemplateMange extends Activity {
	
	private ListView template_drugs_lv;
	public HorizontalScrollView templateTouchView;
	protected List<CHScrollView2> templateHScrollViews =new ArrayList<CHScrollView2>();
 
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.templatemanage);
		initViews();
	}
  
	private void initViews() {
		List<Map<String, String>> datas = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		CHScrollView2 headerScroll = (CHScrollView2) findViewById(R.id.template_item_scroll_title);
		
		templateHScrollViews.add(headerScroll);
		template_drugs_lv = (ListView) findViewById(R.id.template_drugs_lv);
		for(int i = 0; i < 5; i++) {
			data = new HashMap<String, String>();
			data.put("title", "Title_" + i);
			data.put("data_" + 1, "Date_" + 1 + "_" +i );
			data.put("data_" + 2, "Date_" + 2 + "_" +i );
			data.put("data_" + 3, "Date_" + 3 + "_" +i );
			data.put("data_" + 4, "Date_" + 4 + "_" +i );
			data.put("data_" + 5, "Date_" + 5 + "_" +i );
			data.put("data_" + 6, "Date_" + 6 + "_" +i );
			datas.add(data);
		}
		SimpleAdapter templatemanadapter = new ScrollAdapter2(this, datas, R.layout.templatemanage_list
							, new String[] { "title", "data_1", "data_2", "data_3", "data_4", "data_5", "data_6", }
							, new int[] { R.id.template_item_title
										, R.id.template_item_data1
										, R.id.template_item_data2
										, R.id.template_item_data3
										, R.id.template_item_data4
										, R.id.template_item_data5
										});
		template_drugs_lv.setAdapter(templatemanadapter);}
		
	
	public void addHViews(final CHScrollView2 hScrollView) {
		if(!templateHScrollViews.isEmpty()) {
			int size = templateHScrollViews.size();
			CHScrollView2 scrollView = templateHScrollViews.get(size - 1);
			final int scrollX = scrollView.getScrollX();
			
			if(scrollX != 0) {
				template_drugs_lv.post(new Runnable() {
					@Override
					public void run() {
						//��listViewˢ�����֮�󣬰Ѹ����ƶ�������λ��
						hScrollView.scrollTo(scrollX, 0);
					}
				});
			}
		}
		templateHScrollViews.add(hScrollView);
	}
	
	public void onScrollChanged(int l, int t, int oldl, int oldt){
		for(CHScrollView2 scrollView : templateHScrollViews) {
			//��ֹ�ظ�����
			if(templateTouchView != scrollView)
				scrollView.smoothScrollTo(l, t);
		}
	}
	
	class ScrollAdapter2 extends SimpleAdapter {

		private List<? extends Map<String, ?>> datas;
		private int res;
		private String[] from;
		private int[] to;
		private Context context;
		public ScrollAdapter2(Context context,
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
				//��һ�γ�ʼ����ʱ��װ����
				addHViews((CHScrollView2) v.findViewById(R.id.template_item_scroll));
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
	
	//���Ե�����¼� 
	protected View.OnClickListener clickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Toast.makeText(TemplateMange.this, ((TextView)v).getText(), Toast.LENGTH_SHORT).show();
		}
	};
}


	
	
	
	
		
        
		