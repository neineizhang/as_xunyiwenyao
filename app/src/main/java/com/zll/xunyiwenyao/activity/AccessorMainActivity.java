package com.zll.xunyiwenyao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zll.xunyiwenyao.R;

/**
 * Created by kejund on 17/4/6.
 */

public class AccessorMainActivity extends Activity {
    private Button prescription_query,prescription_examine, inspection_query, review_query, report_query, information_manage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maininterface2);

        prescription_query = (Button)findViewById(R.id.prescription_query);
        prescription_examine = (Button) findViewById(R.id.prescription_examine);
        inspection_query = (Button)findViewById(R.id.inspection_query);
        review_query = (Button)findViewById(R.id.review_query);
        report_query = (Button)findViewById(R.id.report_query);
        information_manage = (Button)findViewById(R.id.information_manage);

        prescription_query.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(AccessorMainActivity.this,PrescriptionQueryActivity.class);
                startActivity(i);

            }
        });

        prescription_examine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(AccessorMainActivity.this,PrescriptionExamineActivity.class);
                startActivity(i);

            }
        });

        inspection_query.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(AccessorMainActivity.this,InspectionQueryActivity.class);
                startActivity(i);

            }
        });

        information_manage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(AccessorMainActivity.this,DoctorInformationManageActivity.class);
                startActivity(i);

            }
        });
    }
}
