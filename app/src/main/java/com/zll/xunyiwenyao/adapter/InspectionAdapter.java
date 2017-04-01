package com.zll.xunyiwenyao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.activity.InspectionQueryActivity;
import com.zll.xunyiwenyao.dbitem.Inspection;
import com.zll.xunyiwenyao.webservice.InspectionWebService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kejund on 17/3/31.
 */

public class InspectionAdapter extends BaseAdapter{
    private List<Inspection> itemlist = new ArrayList<Inspection>();
    private Context mContext;

    public InspectionAdapter(List<Inspection> ins_list, Context mContext)
    {   this.mContext = mContext;
        this.itemlist = ins_list;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itemlist.size();
//        return 1;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.inspection_listview, null);


        CheckBox ins_checkbox = (CheckBox) view
                .findViewById(R.id.ins_checkbox);
        TextView ins_list_name = (TextView) view
                .findViewById(R.id.ins_list_name);
        TextView ins_list_date = (TextView) view
                .findViewById(R.id.ins_list_date);
        TextView ins_list_state = (TextView) view
                .findViewById(R.id.ins_list_state);

        ins_list_name.setText(itemlist.get(position).getPatientName().toString());
        ins_list_date.setText(itemlist.get(position).getInspectionDate().toString());
        ins_list_state.setText(itemlist.get(position).getInspectionState().toString());

//        ins_list_name.setText("李四");
//        ins_list_date.setText("B超");
//        ins_list_state.setText("1");
        return view;
    }
}
