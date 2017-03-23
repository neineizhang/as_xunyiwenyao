package com.zll.xunyiwenyao.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.app.TabActivity;
import android.widget.TabHost.TabSpec;
import com.zll.xunyiwenyao.R;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
public class PrescriptionQueryActivity extends TabActivity {

	private  static TabHost query_tabhost ;
	private static Context mContext;
	private static RadioButton query_all;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prescription_query);
		mContext = PrescriptionQueryActivity.this;
		query_tabhost = getTabHost();

		query_all =( RadioButton) findViewById(R.id.query_all);
		query_tabhost=this.getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		intent = new Intent(this,PrescriptionQueryAllPrescriptionActivity.class);
		spec=query_tabhost.newTabSpec("tab1").setIndicator("全部").setContent(intent);
		query_tabhost.addTab(spec);

		intent = new Intent(this,PrescriptionQueryToSubmitActivity.class);
		spec=query_tabhost.newTabSpec("tab2").setIndicator("待提交").setContent(intent);
		query_tabhost.addTab(spec);

		intent = new Intent(this,PrescriptionQueryToApproveActivity.class);
		spec=query_tabhost.newTabSpec("tab3").setIndicator("待审核").setContent(intent);
		query_tabhost.addTab(spec);

		intent = new Intent(this,PrescriptionQueryApprovedActivity.class);
		spec=query_tabhost.newTabSpec("tab4").setIndicator("审核通过").setContent(intent);
		query_tabhost.addTab(spec);

		intent = new Intent(this,PrescriptionQueryRefuseActivity.class);
		spec=query_tabhost.newTabSpec("tab5").setIndicator("审核不通过").setContent(intent);
		query_tabhost.addTab(spec);


		RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
				switch (checkedId) {
					case R.id.query_all:
						query_tabhost.setCurrentTabByTag("tab1");
						break;
					case R.id.query_waitcommit:
						query_tabhost.setCurrentTabByTag("tab2");
						break;
					case R.id.query_waitcheck:
						query_tabhost.setCurrentTabByTag("tab3֪");
						break;
					case R.id.query_commitok:
						query_tabhost.setCurrentTabByTag("tab4");
						break;
					case R.id.query_commitno:
						query_tabhost.setCurrentTabByTag("tab5");
						break;
					default:
						//tabHost.setCurrentTabByTag("�ҵĿ���");
						break;
				}
			}
		});
	}
	public static void changeTo(int id){

		query_tabhost.setCurrentTabByTag("tab1");
		Animation slideLeftIn = AnimationUtils.loadAnimation(mContext, R.anim.slide_left_in);
		query_tabhost.getCurrentView().startAnimation(slideLeftIn);
		query_all.setChecked(true);
	}

}
