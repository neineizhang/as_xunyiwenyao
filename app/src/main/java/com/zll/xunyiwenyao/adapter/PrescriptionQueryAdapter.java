package com.zll.xunyiwenyao.adapter;

import java.util.ArrayList;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Prescription;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PrescriptionQueryAdapter extends BaseAdapter {
	
	private ArrayList<Prescription>  mPrescription;
	private Context mContext;
	
	
	public PrescriptionQueryAdapter(ArrayList<Prescription> mPrescription, Context mContext)
	{   this.mContext = mContext;
	    this.mPrescription = mPrescription;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mPrescription.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = LayoutInflater.from(mContext).inflate(R.layout.prescriptionquery_lvitem,parent, false);
		ImageView prescription_query_item_picture = (ImageView) convertView.findViewById(R.id.prescription_query_item_picture);
		TextView prescription_lvitem_id = (TextView) convertView.findViewById(R.id.prescription_lvitem_id);
		TextView prescription_lvitem_name = (TextView) convertView.findViewById(R.id.prescription_lvitem_name);
		TextView prescription_lvitem_date = (TextView) convertView.findViewById(R.id.prescription_lvitem_date);
		
		prescription_query_item_picture.setBackgroundResource(R.drawable.item_picture);
	
//      prescription_lvitem_id.setText(mPrescription.get(position).getId());
		prescription_lvitem_name.setText(mPrescription.get(position).getName());
		prescription_lvitem_date.setText(mPrescription.get(position).getName());
        return convertView;
	
	}

}
