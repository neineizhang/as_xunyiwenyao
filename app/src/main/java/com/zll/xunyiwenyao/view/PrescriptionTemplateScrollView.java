package com.zll.xunyiwenyao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import com.zll.xunyiwenyao.activity.PrescriptionTemplateMangeActivity;

public class PrescriptionTemplateScrollView extends HorizontalScrollView {

	PrescriptionTemplateMangeActivity activity;

	public PrescriptionTemplateScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		activity = (PrescriptionTemplateMangeActivity) context;
	}
	public PrescriptionTemplateScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		activity = (PrescriptionTemplateMangeActivity) context;
	}

	public PrescriptionTemplateScrollView(Context context) {
		super(context); 
		activity = (PrescriptionTemplateMangeActivity) context;
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
