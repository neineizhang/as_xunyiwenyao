package com.zll.xunyiwenyao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zll.xunyiwenyao.Inspection_create;
import com.zll.xunyiwenyao.Inspection_query;
import com.zll.xunyiwenyao.Inspection_template;
import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.Report;
import com.zll.xunyiwenyao.Review;

public class MainActivity extends Activity{
	
	private Button prescription_create,prescription_query,prescription_template,prescription_examine;
	private Button inspection_create,inspection_template,inspection_query,review,report;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maininterface);
		
		prescription_create = (Button) findViewById(R.id.prescription_create);
		prescription_query = (Button) findViewById(R.id.prescription_query);
		prescription_template = (Button) findViewById(R.id.prescription_template);
		prescription_examine = (Button) findViewById(R.id.prescription_examine);
		
		inspection_create = (Button) findViewById(R.id.inspection_create);
		inspection_template = (Button) findViewById(R.id.inspection_template);
		inspection_query = (Button) findViewById(R.id.inspection_query);
		
		review = (Button) findViewById(R.id.review);
		report = (Button) findViewById(R.id.report);
		
		prescription_create.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(MainActivity.this,PrescriptionCreateActivity.class);
				startActivity(i1);
				
			}
		});
        prescription_template.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2=new Intent(MainActivity.this,PrescriptionTemplateActivity.class);
				startActivity(i2);
				
			}
		});
        
       prescription_query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i3=new Intent(MainActivity.this,PrescriptionQueryActivity.class);
				startActivity(i3);
				
			}
		});
       
       prescription_examine.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i4=new Intent(MainActivity.this,PrescriptionExamineActivity.class);
				startActivity(i4);
				
			}
		});
       
       inspection_create.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i5=new Intent(MainActivity.this, Inspection_create.class);
			startActivity(i5);
		}
    	   
       });
    	   
       inspection_template.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i7=new Intent(MainActivity.this,Inspection_template.class);
				startActivity(i7);
				
			}
		});
       
       inspection_query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i8=new Intent(MainActivity.this,Inspection_query.class);
				startActivity(i8);
				
			}
		});
       
       review.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i9=new Intent(MainActivity.this,Review.class);
				startActivity(i9);
				
			}
		});	
		
       report.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i10=new Intent(MainActivity.this,Report.class);
				startActivity(i10);
				
			}
		});
	}

	}

