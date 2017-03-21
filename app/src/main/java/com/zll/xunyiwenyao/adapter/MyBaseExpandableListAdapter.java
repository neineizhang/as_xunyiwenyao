package com.zll.xunyiwenyao.adapter;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.R.id;
import com.zll.xunyiwenyao.R.layout;
import com.zll.xunyiwenyao.util.Group;
import com.zll.xunyiwenyao.util.Item;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {
	
	private ArrayList<Group> gData;
    private ArrayList<ArrayList<Item>> iData;
    private Context mContext;
    
    public MyBaseExpandableListAdapter(ArrayList<Group> gData,ArrayList<ArrayList<Item>> iData, Context mContext) {
        this.gData = gData;
        this.iData = iData;
        this.mContext = mContext;
    }

   
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return gData.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return iData.get(groupPosition).size();
	}

	@Override
	public Group getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return gData.get(groupPosition);
	}

	@Override
	public Item getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return iData.get(groupPosition).get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	//取得用于显示给定分组的视图. 这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolderGroup groupHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_exlist_group, parent, false);
            groupHolder = new ViewHolderGroup();
            groupHolder.tv_group_name = (TextView) convertView.findViewById(R.id.tv_group_name);
            convertView.setTag(groupHolder);
        }else{
            groupHolder = (ViewHolderGroup) convertView.getTag();
        }
        groupHolder.tv_group_name.setText(gData.get(groupPosition).getgName());
        return convertView;}
    

    //取得显示给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem itemHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.prescription_create_itemlist, parent, false);
            itemHolder = new ViewHolderItem();
            itemHolder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            itemHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(itemHolder);
        }else{
            itemHolder = (ViewHolderItem) convertView.getTag();
        }
        itemHolder.img_icon.setImageResource(iData.get(groupPosition).get(childPosition).getiId());
        itemHolder.tv_name.setText(iData.get(groupPosition).get(childPosition).getiName());
        return convertView;
    }

    //设置子列表是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    private static class ViewHolderGroup{
        private TextView tv_group_name;
    }

    private static class ViewHolderItem{
        private ImageView img_icon;
        private TextView tv_name;
    }

}