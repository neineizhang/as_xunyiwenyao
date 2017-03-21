package com.zll.xunyiwenyao.util;

import com.zll.xunyiwenyao.TemplateMange;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class CHScrollView2 extends HorizontalScrollView {
	
	TemplateMange activity;

	public CHScrollView2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle); 
		activity = (TemplateMange) context;
	}
	public CHScrollView2(Context context, AttributeSet attrs) { 
		super(context, attrs); 
		activity = (TemplateMange) context;
	}
	
	public CHScrollView2(Context context) { 
		super(context); 
		activity = (TemplateMange) context;
	}
	
	@Override  
    public boolean onTouchEvent(MotionEvent ev) {  
        //进行触摸赋值  
        activity.templateTouchView = this;  
        return super.onTouchEvent(ev);  
    }  
      
    @Override  
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {  
        //当当前的CHSCrollView被触摸时，滑动其它  
        if(activity.templateTouchView == this) {  
            activity.onScrollChanged(l, t, oldl, oldt);  
        }else{  
            super.onScrollChanged(l, t, oldl, oldt);  
        }  
    }  
	
}
