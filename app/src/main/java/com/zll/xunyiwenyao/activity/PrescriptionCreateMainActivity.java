package com.zll.xunyiwenyao.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Drug;
import com.zll.xunyiwenyao.dbitem.Patient;
import com.zll.xunyiwenyao.dbitem.Prescription;
import com.zll.xunyiwenyao.dbitem.PrescriptionTemplate;
import com.zll.xunyiwenyao.dbitem.Utils;
import com.zll.xunyiwenyao.view.PrescriptionCreateScrollView;
import com.zll.xunyiwenyao.webservice.DrugWebService;
import com.zll.xunyiwenyao.webservice.PrescriptionTemplateWebService;
import com.zll.xunyiwenyao.webservice.PrescriptionWebService;
import com.zll.xunyiwenyao.webservice.DoctorWebService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class PrescriptionCreateMainActivity extends Activity {

	private Button save, savetotemplate, commit;
	private EditText patient_name_text,patient_sex_text,patient_age_text,chufangmingcheng;
	private EditText prescription_data_et,doctor_name_et,checker_name_et,other_information_et;
	private Button add_drug, dialog_ok_btn;
	private View view_custom;
	private Context mContext;
	private AlertDialog alert = null;
	private AlertDialog.Builder builder = null;
	private ExpandableListView add_drugs_lv;
	private MyExpandableListViewAdapter2 adapter;
	private AutoCompleteTextView add_drugs_autv;
	private Map<String, List<String>> dataset = new HashMap<String, List<String>>();
	// private String[] parentList = new String[] { "first", "second", "third"
	// };
	private String[] parentList = new String[] { "first" };
	private List<String> childrenList1 = new ArrayList<String>();
	private List<String> childrenList2 = new ArrayList<String>();
	private List<String> childrenList3 = new ArrayList<String>();
	private static final String[] data = new String[] { "first", "second", "third", "forth", "fifth" };

	private ListView drugs_lv;
	public HorizontalScrollView mTouchView;
	protected List<PrescriptionCreateScrollView> mHScrollViews = new ArrayList<PrescriptionCreateScrollView>();

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newprescription);

		//锟斤拷始锟斤拷锟斤拷锟斤拷锟斤拷息
		prescription_data_et = (EditText) findViewById(R.id.prescription_data_et);
		doctor_name_et = (EditText) findViewById(R.id.doctor_name_et);
		checker_name_et = (EditText) findViewById(R.id.checker_name_et);
		other_information_et = (EditText) findViewById(R.id.other_information_et);

		prescription_data_et.setText("");
		//在as上运行出现了问题
		doctor_name_et.setText(Utils.LOGIN_DOCTOR.getName());
		checker_name_et.setText("");
		other_information_et.setText("");

		add_drug = (Button) findViewById(R.id.add_drug);

		initViews();
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

		add_drugs_lv = (ExpandableListView) view_custom.findViewById(R.id.add_drugs_lv);
		add_drugs_autv = (AutoCompleteTextView) view_custom.findViewById(R.id.add_drugs_autv);

		dialog_ok_btn = (Button) view_custom.findViewById(R.id.dialog_ok_btn);
		ArrayAdapter<String> autvadapter = new ArrayAdapter<String>(PrescriptionCreateMainActivity.this,
				android.R.layout.simple_dropdown_item_1line, data);
		add_drugs_autv.setAdapter(autvadapter);

		initialData();
		adapter = new MyExpandableListViewAdapter2();
		add_drugs_lv.setAdapter(adapter);
		add_drugs_lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView expandableListView, View view, int parentPos, int childPos,
										long l) {
				add_drugs_autv.setText(dataset.get(parentList[parentPos]).get(childPos));
				Toast.makeText(PrescriptionCreateMainActivity.this, dataset.get(parentList[parentPos]).get(childPos),
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
				String drugname = add_drugs_autv.getText().toString();
				Drug drug = DrugWebService.getDrugByName(drugname);
				if(drug == null){
					/////// !!1!
					alert.dismiss();
					return;
				}

				Map<String, String> tempdata = new HashMap<String, String>();
				tempdata.put("title", String.valueOf(drug.getId()));
				tempdata.put("data_" + 1, drug.getName());
				tempdata.put("data_" + 2, drug.getSpecification());
				tempdata.put("data_" + 3, "1");
				tempdata.put("data_" + 4, drug.getPrice());
				tempdata.put("data_" + 5, drug.getDescription());
				List<Map<String, String>> datas = (List<Map<String, String>>) ((ScrollAdapter)drugs_lv.getAdapter()).getData();
				datas.add(tempdata);
				((ScrollAdapter)drugs_lv.getAdapter()).setData(datas);
				((ScrollAdapter)drugs_lv.getAdapter()).notifyDataSetChanged();
				alert.dismiss();
			}
		});

		mContext = this;

		save = (Button) findViewById(R.id.save);
		savetotemplate = (Button) findViewById(R.id.savetotemplate);
		commit = (Button) findViewById(R.id.commit);
		chufangmingcheng = (EditText) findViewById(R.id.editText1);
		patient_name_text = (EditText) findViewById(R.id.patient_name_text);
		patient_sex_text = (EditText) findViewById(R.id.patient_sex_text);
		patient_age_text = (EditText) findViewById(R.id.patient_age_text);

		///////////// add template data
		Bundle extras = getIntent().getExtras();
		String template_name = extras.getString("template_name");
		if(!template_name.trim().equals("")){
			PrescriptionTemplate prescriptionTemplate = PrescriptionTemplateWebService.getPrescriptionTemplateByName(template_name);
			if(prescriptionTemplate == null){
				/////// zlladd TOAST

			}else{
				//chufangmingcheng.setText(template_name);

				Map<Drug, Integer> drugmap = prescriptionTemplate.getDrugmap();
				List<Map<String, String>> datas = (List<Map<String, String>>) ((ScrollAdapter)drugs_lv.getAdapter()).getData();
				if(datas == null){
					datas = new ArrayList<Map<String,String>>();
				}
				for(Drug drug : drugmap.keySet()){
					Map<String, String> tempdata = new HashMap<String, String>();
					tempdata.put("title", String.valueOf(drug.getId()));
					tempdata.put("data_" + 1, drug.getName());
					tempdata.put("data_" + 2, drug.getSpecification());
					tempdata.put("data_" + 3, drugmap.get(drug)+"");
					tempdata.put("data_" + 4, drug.getPrice());
					tempdata.put("data_" + 5, drug.getDescription());
					datas.add(tempdata);
				}
				((ScrollAdapter)drugs_lv.getAdapter()).setData(datas);
				((ScrollAdapter)drugs_lv.getAdapter()).notifyDataSetChanged();
			}

		}
		///////////// end add template data


		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String prescription_name = chufangmingcheng.getText().toString();
				String patient_name = patient_name_text.getText().toString();
				String patient_sex = patient_sex_text.getText().toString();
				String patient_age = patient_age_text.getText().toString();

				Patient patient = new Patient();
				patient.setAge(Integer.valueOf(patient_age));
				patient.setName(patient_name);
				patient.setSex(Integer.valueOf(patient_sex));

				Map<Drug, Integer> drugmap = new HashMap<Drug, Integer>();
				//List<Drug> druglt = new ArrayList<Drug>();
				List<Map<String, String>> datas = (List<Map<String, String>>) ((ScrollAdapter)drugs_lv.getAdapter()).getData();
				for(Map<String, String> item : datas){
					Drug drug = new Drug();
					drug.setId(Integer.parseInt(item.get("title")));
					drug.setDescription(item.get("data_5"));
					drug.setPrice(item.get("data_4"));
					drug.setName(item.get("data_1"));
					drug.setSpecification(item.get("data_2"));
					int count = Integer.valueOf(item.get("data_3"));
					drugmap.put(drug, count);
				}

				Prescription prescription = new Prescription();
				prescription.setPatient(patient);
				prescription.setName(prescription_name);
				prescription.setDrugmap(drugmap);
				prescription.setStatus(Utils.STATUS.SAVED.ordinal());

				PrescriptionWebService.AddPrescription(prescription);

				Toast.makeText(mContext, "SAVE SUCCESS", Toast.LENGTH_SHORT).show();
			}
		});
		savetotemplate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String prescription_name = chufangmingcheng.getText().toString();
				PrescriptionTemplate prescriptionTemplate_indb = PrescriptionTemplateWebService.getPrescriptionTemplateByName(prescription_name);
				if(prescriptionTemplate_indb != null){
					Toast.makeText(mContext, "HAVED, SAVE FAILURE", Toast.LENGTH_SHORT).show();
					return;
				}

				Map<Drug, Integer> drugmap = new HashMap<Drug, Integer>();
				List<Map<String, String>> datas = (List<Map<String, String>>) ((ScrollAdapter)drugs_lv.getAdapter()).getData();
				for(Map<String, String> item : datas){
					Drug drug = new Drug();
					drug.setId(Integer.parseInt(item.get("title")));
					drug.setDescription(item.get("data_5"));
					drug.setPrice(item.get("data_4"));
					drug.setName(item.get("data_1"));
					drug.setSpecification(item.get("data_2"));
					int count = Integer.valueOf(item.get("data_3"));
					drugmap.put(drug, count);
				}

				PrescriptionTemplate prescriptionTemplate = new PrescriptionTemplate();
				prescriptionTemplate.setName(prescription_name);
				prescriptionTemplate.setDrugmap(drugmap);
				PrescriptionTemplateWebService.addPrescriptionTemplate(prescriptionTemplate);

				Toast.makeText(mContext, "SAVE SUCCESS", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
		commit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String prescription_name = chufangmingcheng.getText().toString();
				String patient_name = patient_name_text.getText().toString();
				String patient_sex = patient_sex_text.getText().toString();
				String patient_age = patient_age_text.getText().toString();

				Patient patient = new Patient();
				patient.setAge(Integer.valueOf(patient_age));
				patient.setName(patient_name);
				patient.setSex(Integer.valueOf(patient_sex));

				Map<Drug, Integer> drugmap = new HashMap<Drug, Integer>();
				//List<Drug> druglt = new ArrayList<Drug>();
				List<Map<String, String>> datas = (List<Map<String, String>>) ((ScrollAdapter)drugs_lv.getAdapter()).getData();
				for(Map<String, String> item : datas){
					Drug drug = new Drug();
					drug.setId(Integer.parseInt(item.get("title")));
					drug.setDescription(item.get("data_5"));
					drug.setPrice(item.get("data_4"));
					drug.setName(item.get("data_1"));
					drug.setSpecification(item.get("data_2"));
					int count = Integer.valueOf(item.get("data_3"));
					drugmap.put(drug, count);
				}

				Prescription prescription = new Prescription();
				prescription.setPatient(patient);
				prescription.setName(prescription_name);
				prescription.setDrugmap(drugmap);
				prescription.setStatus(Utils.STATUS.COMMITED.ordinal());

				PrescriptionWebService.AddPrescription(prescription);

				Toast.makeText(mContext, "SAVE SUCCESS", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}

	private void initialData() {
		// childrenList1.add(parentList[0] + "-" + "first");
		// childrenList1.add(parentList[0] + "-" + "second");
		// childrenList1.add(parentList[0] + "-" + "third");
		// childrenList2.add(parentList[1] + "-" + "first");
		// childrenList2.add(parentList[1] + "-" + "second");
		// childrenList2.add(parentList[1] + "-" + "third");
		// childrenList3.add(parentList[2] + "-" + "first");
		// childrenList3.add(parentList[2] + "-" + "second");
		// childrenList3.add(parentList[2] + "-" + "third");
		// dataset.put(parentList[0], childrenList1);
		// dataset.put(parentList[1], childrenList2);
		// dataset.put(parentList[2], childrenList3);

		List<String> namelt = new ArrayList<String>();
		List<Drug> resultDruglt = DrugWebService.getAllDrug();
		// System.out.println(resultDruglt.size());
		for (Drug item : resultDruglt) {
			namelt.add(item.getName());
		}
		dataset.put("first", namelt);
	}

	private class MyExpandableListViewAdapter2 extends BaseExpandableListAdapter {

		@Override
		public Object getChild(int parentPos, int childPos) {
			return dataset.get(parentList[parentPos]).get(childPos);
		}

		@Override
		public int getGroupCount() {
			return dataset.size();
			// return 0;
		}

		@Override
		public int getChildrenCount(int parentPos) {
			return dataset.get(parentList[parentPos]).size();
		}

		@Override
		public Object getGroup(int parentPos) {
			return dataset.get(parentList[parentPos]);
		}

		@Override
		public long getGroupId(int parentPos) {
			return parentPos;
		}

		@Override
		public long getChildId(int parentPos, int childPos) {
			return childPos;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public View getChildView(int parentPos, int childPos, boolean b, View view, ViewGroup viewGroup) {
			if (view == null) {
				LayoutInflater inflater = (LayoutInflater) PrescriptionCreateMainActivity.this
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.add_drugs_dialog_item, null);
			}
			view.setTag(R.layout.add_drugs_dialog_list, parentPos);
			view.setTag(R.layout.add_drugs_dialog_item, childPos);
			TextView text = (TextView) view.findViewById(R.id.add_drugs_dialog_item);
			text.setText(dataset.get(parentList[parentPos]).get(childPos));
			// text.setOnClickListener(new View.OnClickListener() {
			// @Override
			// public void onClick(View view) {
			// Toast.makeText(New_prescription.this, "閻愮懓鍩屾禍鍡楀敶缂冾喚娈憈extview",
			// Toast.LENGTH_SHORT).show();
			// }
			// });
			return view;
		}

		@Override
		public boolean isChildSelectable(int i, int i1) {
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolderGroup groupHolder;
			if (convertView == null) {
				convertView = LayoutInflater.from(PrescriptionCreateMainActivity.this)
						.inflate(R.layout.item_exlist_group, parent, false);
				groupHolder = new ViewHolderGroup();
				groupHolder.tv_group_name = (TextView) convertView.findViewById(R.id.tv_group_name);
				convertView.setTag(groupHolder);
			} else {
				groupHolder = (ViewHolderGroup) convertView.getTag();
			}
			groupHolder.tv_group_name.setText(parentList[0]);
			return convertView;
		}

		private class ViewHolderGroup {
			private TextView tv_group_name;
		}
	}

	private void initViews() {
		List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
		Map<String, String> data = null;
		PrescriptionCreateScrollView headerScroll = (PrescriptionCreateScrollView) findViewById(R.id.item_scroll_title);

		mHScrollViews.add(headerScroll);

		drugs_lv = (ListView) findViewById(R.id.drugs_lv);

//		for (int i = 0; i < 1; i++) {
//			data = new HashMap<String, String>();
//			data.put("title", "Title_" + i);
//			data.put("data_" + 1, "Date_" + 1 + "_" + i);
//			data.put("data_" + 2, "Date_" + 2 + "_" + i);
//			data.put("data_" + 3, "Date_" + 3 + "_" + i);
//			data.put("data_" + 4, "Date_" + 4 + "_" + i);
//			data.put("data_" + 5, "Date_" + 5 + "_" + i);
//
//			datas.add(data);
//		}

		ScrollAdapter adapter = new ScrollAdapter(this, datas, R.layout.scroll_item,
				new String[] { "title", "data_1", "data_2", "data_3", "data_4", "data_5" }, new int[] { R.id.item_title,
				R.id.item_data1, R.id.item_data2, R.id.item_data3, R.id.item_data4, R.id.item_data5 });
		drugs_lv.setAdapter(adapter);

	}

	public void addHViews(final PrescriptionCreateScrollView hScrollView) {
		if (!mHScrollViews.isEmpty()) {
			int size = mHScrollViews.size();
			PrescriptionCreateScrollView scrollView = mHScrollViews.get(size - 1);

			final int scrollX = scrollView.getScrollX();
			if (scrollX != 0) {
				drugs_lv.post(new Runnable() {
					@Override
					public void run() {
						hScrollView.scrollTo(scrollX, 0);
					}
				});
			}
		}
		mHScrollViews.add(hScrollView);
	}

	public void onScrollChanged(int l, int t, int oldl, int oldt) {
		for (PrescriptionCreateScrollView scrollView : mHScrollViews) {
			if (mTouchView != scrollView)
				scrollView.smoothScrollTo(l, t);
		}
	}

	class ScrollAdapter extends SimpleAdapter {

		private List<? extends Map<String, ?>> datas;
		private int res;
		private String[] from;
		private int[] to;
		private Context context;

		public ScrollAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from,
							 int[] to) {
			super(context, data, resource, from, to);
			this.context = context;
			this.datas = data;
			this.res = resource;
			this.from = from;
			this.to = to;
		}

		public void setData(List<? extends Map<String, ?>> newdatas){
			datas = newdatas;
		}

		public List<? extends Map<String, ?>> getData(){
			return datas;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				v = LayoutInflater.from(context).inflate(res, null);
				addHViews((PrescriptionCreateScrollView) v.findViewById(R.id.item_scroll));
				View[] views = new View[to.length];
				for (int i = 0; i < to.length; i++) {
					View tv = v.findViewById(to[i]);
					;
					tv.setOnClickListener(clickListener);
					views[i] = tv;
				}
				v.setTag(views);
			}
			View[] holders = (View[]) v.getTag();
			int len = holders.length;
			for (int i = 0; i < len; i++) {
				((TextView) holders[i]).setText(this.datas.get(position).get(from[i]).toString());
			}
			return v;
		}
	}

	protected View.OnClickListener clickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Toast.makeText(PrescriptionCreateMainActivity.this, ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
		}
	};

}
