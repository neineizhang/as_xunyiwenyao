package com.zll.xunyiwenyao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import com.zll.xunyiwenyao.activity.PrescriptionCreateActivity;
import com.zll.xunyiwenyao.activity.PrescriptionCreateMainActivity;

public class PrescriptionCreateScrollView extends HorizontalScrollView {

	PrescriptionCreateMainActivity activity;

	public PrescriptionCreateScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		activity = (PrescriptionCreateMainActivity) context;
	}
	public PrescriptionCreateScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		activity = (PrescriptionCreateMainActivity) context;
	}

	public PrescriptionCreateScrollView(Context context) {
		super(context); 
		activity = (PrescriptionCreateMainActivity) context;
	}
	
	@Override  
    public boolean onTouchEvent(MotionEvent ev) {  
        //进行触摸赋值  
        activity.mTouchView = this;  
        return super.onTouchEvent(ev);  
    }  
      
    @Override  
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {  
        //当当前的CHSCrollView被触摸时，滑动其它  
        if(activity.mTouchView == this) {  
            activity.onScrollChanged(l, t, oldl, oldt);  
        }else{  
            super.onScrollChanged(l, t, oldl, oldt);  
        }  
    }  
	
}
