package com.zll.xunyiwenyao.util;

import com.zll.xunyiwenyao.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
 
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 */
public class TopBarView extends RelativeLayout 
implements  OnClickListener{

	private ImageView backView;
    private ImageView rightView;
    private TextView titleView;

    private String titleTextStr; 
    private int titleTextSize ;
    private int  titleTextColor ;
 
    private Drawable leftImage ;
    private Drawable rightImage ;
    
    public TopBarView(Context context){
        this(context, null);
    }


    public TopBarView(Context context, AttributeSet attrs) {
      this(context, attrs,R.style.AppTheme);
        

 	}

    public TopBarView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		getConfig(context, attrs);  
        initView(context);
	}
    
    /**
     */ 
    private void getConfig(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.Topbar);  
         
        int count = ta.getIndexCount();
        for(int i = 0;i<count;i++)
        {
            int attr = ta.getIndex(i);  
            switch (attr)  
            {  
            case R.styleable.Topbar_titleText:  
            	titleTextStr = ta.getString(R.styleable.Topbar_titleText);    
                break;
            case R.styleable.Topbar_titleColor:
            	titleTextColor = ta.getColor(attr, Color.BLACK);  
                break;  
            case R.styleable.Topbar_titleSize:
                titleTextSize = ta.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(  
                        TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));  
                break;  
  
            case R.styleable.Topbar_leftBtn:  
        
            	leftImage = ta.getDrawable(R.styleable.Topbar_leftBtn);  
                break; 
            case R.styleable.Topbar_rightBtn:  
            	rightImage = ta.getDrawable(R.styleable.Topbar_rightBtn); 
                break; 
            } 
        }

        ta.recycle(); 
		
	}


	private void initView(Context context)
    {
		View layout = LayoutInflater.from(context).inflate(R.layout.custom_groupwidget, 
				this,true);
        
        backView = (ImageView) layout.findViewById(R.id.back_image);
        titleView = (TextView) layout.findViewById(R.id.text_title);
        rightView = (ImageView) layout.findViewById(R.id.right_image);
        backView.setOnClickListener(this);
        rightView.setOnClickListener(this);
        
        if(null != leftImage)
        backView.setImageDrawable(leftImage);
        if(null != rightImage)
        rightView.setImageDrawable(rightImage);
        if(null != titleTextStr)
        {
        	titleView.setText(titleTextStr);
        	titleView.setTextSize(titleTextSize);
        	titleView.setTextColor(titleTextColor);
        }
    }
    /**
     * @return
     */
    public ImageView getBackView() {
        return backView;
    }

    /**
     * @return
     */
    public TextView getTitleView() {
        return titleView;
    }

    /**
     * @param title
     */
    public void setTitle(String title){
        titleView.setText(title);
    }

    /**
     * @return
     */
    public ImageView getRightView() {
        return rightView;
    }

    private onTitleBarClickListener onMyClickListener;
    
    /**
     * @param callback
     */
    public void setClickListener(onTitleBarClickListener listener) {
        this.onMyClickListener = listener;
    }

    /**
     */
    public static interface onTitleBarClickListener{
        /**
         */
        void onBackClick();

        void onRightClick();
    }

	@Override
	public void onClick(View v) {
	 int id = v.getId();
	 switch(id)
	 {
	 case R.id.back_image:
		 if(null != onMyClickListener)
		 onMyClickListener.onBackClick();
		 break;
	 case R.id.right_image:
		 if(null != onMyClickListener)
		 onMyClickListener.onRightClick();
		 break;
	 }	
	}
}