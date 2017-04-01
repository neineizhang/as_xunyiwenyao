package com.zll.xunyiwenyao.activity;

import com.zll.xunyiwenyao.R;
import com.zll.xunyiwenyao.dbitem.Inspection;
import com.zll.xunyiwenyao.util.TopBarView;
import com.zll.xunyiwenyao.util.TopBarView.onTitleBarClickListener;
import com.zll.xunyiwenyao.webservice.InspectionWebService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InspectionTemplateActivity extends Activity  implements onTitleBarClickListener{

	private  TopBarView topbar;
	private Button btn_query;
	private TextView qResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inspection_template);
		
		topbar = (TopBarView)findViewById(R.id.topbar);
		
		topbar.setClickListener(this);

		btn_query = (Button)findViewById(R.id.button_query);
		qResult = (TextView)findViewById(R.id.query_result);
		btn_query.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getInspection();
            }
        });
	}
	@Override
	public void onBackClick() {
		InspectionTemplateActivity.this.finish();
	}
	@Override
	public void onRightClick() {
		Toast.makeText(InspectionTemplateActivity.this, "你点击了右侧按钮", Toast.LENGTH_SHORT).show();
		
	}

    public void getInspection(){
        List<Inspection> itemlist = new ArrayList<Inspection>();
        itemlist = InspectionWebService.getAllInspection();
        String s="";

        if(itemlist.size()>0){
            System.out.println("查询结果为：");
            for(int i=0;i<itemlist.size();i++){
                Inspection item = itemlist.get(i);
                String name = item.getPatientName();
                String date = item.getInspectionDate();
                String state = item.getInspectionState();
                s=s+"id:"+i+"    name: "+name+"    date:"+date+"    state:"+state+"\r\n";
            }
            qResult.setText(s);
        }else{
            qResult.setText("查询结果为空");
        }
    }
}
